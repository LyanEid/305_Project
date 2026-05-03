package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Flights {
    protected String flightNo;
    private String departure;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private Date date;
    protected DB db = DB.getInstance();
    static ArrayList<Flights> flights = new ArrayList<Flights>();//this is must be in main

    public void setFlights() throws SQLException {
        try(ResultSet rs = db.retrive("SELECT * FROM FLIGHTS WHERE FLIGHT_ID = "+flightNo+";")) {
            while (rs.next()) {
                this.flightNo = rs.getString("flight_id");
                departure = rs.getString("departure_city");
                destination = rs.getString("destination");
                departureTime = rs.getString("departure_time");
                arrivalTime = rs.getString("arrival_time");
                date = rs.getDate("date");
                flights.add(this);
            }
        }
    }
    public Flights() {

    }
    public void display(){

    }
    public int getTotalSeats() throws SQLException {

           return Integer.valueOf(String.valueOf(db.retrive("SELECT TOTAL_B_SEATS+ TOTAL_E_SEATS FROM FLIGHTS WHERE FLIGHT_ID = "+flightNo+";")));
       }


}
