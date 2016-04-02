package com.twair;

/**
 * Created by sangeeth on 01-04-2016.
 */
public class TravellingClass {
    public int getPrice() {
        return price;
    }

    private final int price;

    private String travellingClass;
    private int availableSeats;


    public TravellingClass(String travellingClass, int availableSeats, int price) {
        this.travellingClass = travellingClass;
        this.availableSeats = availableSeats;
        this.price = price;
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