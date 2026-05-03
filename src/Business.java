package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Business extends Flights {
    private int total_seats;
    private String seatNumber;
    private boolean availablity;
    private double price;



    public Business(String flightNo) throws SQLException {
        super();
        try(ResultSet rs = db.retrive("Select * from economey WHERE flight_ID ="+flightNo+";")) {
            seatNumber = rs.getString("seat_number");
            availablity = rs.getBoolean("availablity");
            price = rs.getDouble("price");
            total_seats = super.getTotalSeats();
        }
    }

    @Override
    public void display() {

    }
    public void SetSeatNumber(String Operaion) throws SQLException {
        if(Operaion.equalsIgnoreCase("CANCEL"))
            db.update("UPDATE FLIGHTS SET TOTAL_b_SEATS"+(total_seats++)+" , WHERE FLIGHT_ID = "+super.flightNo+";");
        else
            db.update("UPDATE FLIGHTS SET TOTAL_b_SEATS"+(total_seats--)+" , WHERE FLIGHT_ID = "+super.flightNo+";");

    }


}


