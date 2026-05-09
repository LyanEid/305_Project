package org.example;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;

// add a cache excuter pool
    private BookingManager bookingManager;

    public ClientHandler(Socket socket, BookingManager bookingManager) {
        this.socket = socket;
        this.bookingManager = bookingManager;
    }

    @Override
    public void run() {
        try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream  in  = new ObjectInputStream(socket.getInputStream())) {

            Object request = in.readObject();

            // --- CASE 1: Registration ---

            if (request instanceof User) {
                User u = (User) request;
                DB.Add(u);
                out.writeObject("SUCCESS_REG"); // tell client it worked

                // --- CASE 2: String command (BOOK or SEARCH) ---
            } else if (request instanceof String) {
                String reqStr = (String) request;

                // --- BOOK request ---

                // Split into max 3 parts to handle passenger names with colons
                if (reqStr.startsWith("BOOK:")) {
                    String[] parts = reqStr.split(":", 3);


                    if (parts.length < 3 || parts[1].isBlank() || parts[2].isBlank()) {
                        out.writeObject("ERROR: Invalid BOOK request. Expected BOOK:<flightId>:<passengerName>");
                    } else {
                        String flightId      = parts[1].trim();
                        String passengerName = parts[2].trim();

                        // bookSeat() is synchronized — only one thread enters at a time.
                        // This prevents two passengers from booking the last seat simultaneously.
                        String result = bookingManager.bookSeat(flightId, passengerName);
                        out.writeObject(result);
                    }

                    // --- SEARCH request ---
                    // Expected format: "SEARCH:<flightId>"
                } else if (reqStr.startsWith("SEARCH:")) {
                    String[] parts = reqStr.split(":", 2);

                    // Validate that we got the flight ID
                    if (parts.length < 2 || parts[1].isBlank()) {
                        out.writeObject("ERROR: Invalid SEARCH request. Expected SEARCH:<flightId>");
                    } else {
                        String flightId = parts[1].trim();

                        // searchFlight() queries the DB fresh every time —
                        // always returns the real current seat count
                        String result = bookingManager.searchFlight(flightId);
                        out.writeObject(result);
                    }

                    // --- Unknown command ---
                } else {
                    out.writeObject("ERROR: Unknown request: " + reqStr);
                }

                // --- CASE 3: Unrecognized type ---
            } else {
                out.writeObject("ERROR: Unrecognized request type.");
            }


            out.flush();

        } catch (Exception e) {
            System.err.println("Handler Error: " + e.getMessage());
        } finally {

            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
