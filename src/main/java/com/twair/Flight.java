package com.twair;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class Flight {
    private String source;
    private String destination;
    private Plane plane;
    private String number;
    private Integer availableSeats;
    private Calendar departureTime;
    private Calendar arrivalTime;
    private ArrayList<TravellingClass> availableClasses = new ArrayList<>();
    private int economyClassSeats;
    private int firstClassSeats;

    public Flight(String number, String source, String destination, Plane plane, Calendar departure, Calendar arrival) throws Exception {
        this.source = source;
        this.destination = destination;
        this.plane = plane;
        this.number = number;
        this.availableSeats = plane.getNumberOfSeats();
        setScheduleTime(departure, arrival);
    }

    public void setClassesAndSeatsInfo(HashMap<String, Integer> availableClasses)
    {
        for (String key:availableClasses.keySet())
        {
            this.availableClasses.add(new TravellingClass(key.toString(),availableClasses.get(key)));
        }
    }

    public boolean canBook(Integer numberOfSeats) {
        return this.availableSeats - numberOfSeats >= 0;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getNumber() {
        return number;
    }

    public Calendar getDepartureTime() {
        return departureTime;
    }

    public Calendar getArrivalTime() {
        return arrivalTime;
    }

    private void setScheduleTime(Calendar departureTime, Calendar arrivalTime) throws Exception {
        if(departureTime.after(arrivalTime)) {
            throw new Exception("departure time cannot be greater than arrival time");
        }
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public int getAvailableSeatsByClass(String classs)
    {
        int noOfSeats = 0;
        for(TravellingClass travellingInfo : this.availableClasses)
        {
            if(classs.equals(travellingInfo.getTravellingClass()))
            {
                noOfSeats =  travellingInfo.getAvailableSeats();
            }
        }
        return noOfSeats;
    }
}
