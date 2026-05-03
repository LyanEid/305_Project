package org.example;

import java.sql.SQLException;

public class Ticket {
    private String ticketID;
    private User user;
    private Flights flight;
    private String seatNumber;
    private String seatType;
    private String seatPrice;
    DB db = DB.getInstance();

    public Ticket(String ticketID, User user, String flights, String seatNumber, String seatType, String seatPrice) {
        this.ticketID = ticketID;
        this.user = user;
        this.flight = flight;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seatPrice = seatPrice;
    }
    public boolean cancelTicket() throws SQLException {
        db.update("delete from tickets, where ticket_id="+ticketID);
        return true;
    }
}
