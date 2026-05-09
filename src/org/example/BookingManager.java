package org.example;

/* شرح الكلاس
BookingManager
The brain of the booking system    1) holds the seat availability for each flight
                                   2) makes sure that when multiple users try to book at the same time, only one request is processed at a time using synchronized
                                   3) prevents Overbooking
*/

import java.util.HashMap;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingManager {
    private Map<String, Integer> flightSeats = new HashMap<>();

    public BookingManager() {
        try {
            ResultSet rs = DB.getInstance().retrive(
                    "SELECT flight_id, (total_b_seats + total_e_seats) AS total FROM flights"
            );
            while (rs.next()) {
                flightSeats.put(rs.getString("flight_id"), rs.getInt("total"));
            }
        } catch (SQLException e) {
            System.err.println("Failed to load flights from DB: " + e.getMessage());
        }
    }

    public synchronized String bookSeat(String flightId, String passengerName) {
        if (!flightSeats.containsKey(flightId)) {
            return "ERROR: Flight " + flightId + " not found.";
        }

        int availableSeats = flightSeats.get(flightId);

        if (availableSeats <= 0) {
            return "FAILED: No available seats on flight " + flightId;
        }

        // Update DB first — if it fails, the map stays unchanged
      // add the same code for business (if-else)
      // user must  choose the seat after checking if available
        try {
            DB.getInstance().update(
                    "UPDATE flights SET total_e_seats = total_e_seats - 1 " +
                            "WHERE flight_id = '" + flightId + "' AND total_e_seats > 0"
            );
        } catch (SQLException e) {
            return "DATABASE ERROR: " + e.getMessage();
        }
      //check if the passanger is an adult

        // DB succeeded — now update
        flightSeats.put(flightId, availableSeats - 1);
      // user Add method in DB to save the ticket info

        System.out.println("[BOOKED] " + passengerName + " booked a seat on " + flightId +
                " | Remaining seats: " + (availableSeats - 1));
        return "SUCCESS: Seat booked for " + passengerName + " on flight " + flightId;
      //invoke method print invoice 
    }

   /* public String searchFlight(String flightId) {

        try {
            ResultSet rs = DB.getInstance().retrive(
                    "SELECT (total_b_seats + total_e_seats) AS total FROM flights " +
                            "WHERE flight_id = '" + flightId + "'"
            );
            if (rs.next()) {
                flightSeats.put(flightId, rs.getInt("total"));
            }
        } catch (SQLException e) {
            System.err.println("Search error: " + e.getMessage());
        }

        if (!flightSeats.containsKey(flightId)) {
            return "Flight " + flightId + " not found.";
        }

        int seats = flightSeats.get(flightId);
        return "Flight " + flightId + " | Available seats: " + seats;
    }**/
}
