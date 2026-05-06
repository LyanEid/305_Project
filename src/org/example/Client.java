package org.example;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Client {


    private static final String HOST = "localhost";
    private static final int    PORT = 5500;


    public static String send(Object request) throws Exception {
        try (Socket socket = new Socket(HOST, PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream  in  = new ObjectInputStream(socket.getInputStream())) {

            // Send the request to the server
            out.writeObject(request);
            out.flush(); // make sure all bytes leave the buffer immediately

            // Wait for and read the server's response
            Object response = in.readObject();

            if (response instanceof String) {
                return (String) response;
            }
            throw new Exception("Unexpected response type from server.");
        }
    }

    /*
     * Ask the server how many seats are available on a flight.
     * Sends: "SEARCH:<flightId>"
     * Returns: "Flight FL123 | Available seats: 5"
     */
    public static String searchFlight(String flightId) throws Exception {
        return send("SEARCH:" + flightId);
    }


     //Book a seat for a passenger on a specific flight.

    public static String bookFlight(String flightId, String passengerName) throws Exception {
        return send("BOOK:" + flightId + ":" + passengerName);
    }

    public static String registerUser(User user) throws Exception {
        return send(user);
    }

   // Quick manual test —
    public static void main(String[] args) {
        try {
            System.out.println("=== Search Test ===");
            System.out.println(searchFlight("FL123"));

            System.out.println("\n=== Book Test ===");
            System.out.println(bookFlight("FL123", "TestPassenger"));

            System.out.println("\n=== Search After Book ===");
            System.out.println(searchFlight("FL123"));

        } catch (Exception e) {
            System.err.println("Could not connect to the server. Is it running?");
            e.printStackTrace();
        }
    }
}