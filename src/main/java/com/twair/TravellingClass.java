package com.twair;

/**
 * Created by sangeeth on 01-04-2016.
 */
public class TravellingClass {
    private String travellingClass;
    private int availableSeats;

    public TravellingClass(String travellingClass, int availableSeats) {
        this.travellingClass = travellingClass;
        this.availableSeats = availableSeats;
    }

    public String getTravellingClass()
    {
        return this.travellingClass;
    }
    public int getAvailableSeats()
    {
        return this.availableSeats;
    }
}