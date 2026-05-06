//package org.example;/*  شرح الكلاس
//TestConcurrency          1) A testing class only
//                         2) It simulates many passengers trying to book the same flight at the same time + وكيف تنحل المشكلة
//*/
//import org.example.BookingManager;
//
//import java.util.List;
//public class TestConcurrency {
//    public static void main(String[] args) throws InterruptedException {
//        BookingManager manager = new BookingManager();
//
//        // TODO: <<Database>> fetch all passengers for this flight from DB
//        String flightId = "";
//
//
//
//
//        List<String> passengers = null; // TODO: <<Database>> replace null with DB query result (list of passenger names)
//
//
//
//        // TODO: <<Database>> provide a search user and flight from DB
//        String searchUser = "";
//        String searchFlight = "";
//
//
//        Thread[] bookingThreads = new Thread[passengers.size()];
//        for (int i = 0; i < passengers.size(); i++) {
//            bookingThreads[i] = new Thread(new BookingThread(manager, flightId, passengers.get(i)));
//        }
//
//
//        Thread searchThread = new Thread(new SearchThread(manager, searchFlight, searchUser));
//
//
//        for (Thread t : bookingThreads) t.start();
//        searchThread.start();
//
//
//        for (Thread t : bookingThreads) t.join();
//        searchThread.join();
//
//        System.out.println("\n=== Final Result ===");
//        System.out.println(manager.searchFlight(flightId));
//    }
//}
package org.example;

/* شرح الكلاس
TestConcurrency          1) A testing class only
                         2) It simulates many passengers trying to book the same flight at the same time + وكيف تنحل المشكلة
*/

import java.util.List;

public class TestConcurrency {
    public static void main(String[] args) throws InterruptedException {

        // One shared manager — this is the whole point of the test
        BookingManager manager = new BookingManager();

        // The flight to test with — must exist in the DB
        String flightId = "FL123";

        // Simulated passengers — more than the available seats to test overbooking prevention
        List<String> passengers = List.of(
                "Ali", "Sara", "Omar", "Lina", "Khalid",
                "Nora", "Faisal", "Hana", "Tariq", "Reem"
        );

        // Search user to run in parallel while bookings happen
        String searchUser   = "Mona";
        String searchFlight = "FL123";

        // Create one booking thread per passenger
        Thread[] bookingThreads = new Thread[passengers.size()];
        for (int i = 0; i < passengers.size(); i++) {
            bookingThreads[i] = new Thread(new BookingThread(manager, flightId, passengers.get(i)));
        }

        // Search thread runs at the same time as the bookings
        Thread searchThread = new Thread(new SearchThread(manager, searchFlight, searchUser));

        // Start all threads simultaneously
        for (Thread t : bookingThreads) t.start();
        searchThread.start();

        // Wait for all to finish
        for (Thread t : bookingThreads) t.join();
        searchThread.join();

        System.out.println("\n=== Final Result ===");
        System.out.println(manager.searchFlight(flightId));
    }
}
