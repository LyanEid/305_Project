package org.example;/* شرح الكلاس
BookingThread        1) Represents a single passenger trying to book a seat 
                     2) Every passenger gets their own thread so all requests can happen simultaneously
*/

import org.example.BookingManager;

public class BookingThread implements Runnable {
    private BookingManager bookingManager;
    private String flightId;
    private String passengerName;

    public BookingThread(BookingManager bookingManager, String flightId, String passengerName) {
        this.bookingManager = bookingManager;
        this.flightId = flightId;
        this.passengerName = passengerName;
    }

    @Override
    public void run() {
        System.out.println("[ATTEMPT] " + passengerName + " attempting to book flight " + flightId);
        String result = bookingManager.bookSeat(flightId, passengerName);
        System.out.println("[RESPONSE] " + result);
    }
}
