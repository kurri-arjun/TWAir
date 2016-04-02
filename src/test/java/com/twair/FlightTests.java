package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class FlightTests {
    private String source;
    private String dest;
    private Plane plane;
    private Calendar departure;
    private Calendar arrival;
    private Flight flightInfo;

    @Before
    public void setUp() throws Exception {
        HashMap<String, Integer> classesInfo = new HashMap<>();
        classesInfo.put("Business Class", 10);
        classesInfo.put("First Class", 21);
        classesInfo.put("Economy Class", 103);
        source = "TestSource";
        dest = "TestDestination";
        plane = new Plane("type", 30);
        departure = new GregorianCalendar(2016,3,10, 9, 10, 0);
        arrival = new GregorianCalendar(2016,3,10, 10, 10, 0);
        flightInfo = new Flight("F001",source, dest, plane, departure, arrival);
        flightInfo.setClassesAndSeatsInfo(classesInfo);
    }

    @Test
    public void shouldHaveSourceDestination() throws Exception {
        Assert.assertEquals(source, flightInfo.getSource());
        Assert.assertEquals(dest, flightInfo.getDestination());
    }

    @Test
    public void shouldReturnTrueIfNumberOfSeatsCanBeBooked() throws Exception {
        Integer numberOfSeats = 10;
        Assert.assertTrue(flightInfo.canBook(numberOfSeats));
    }

    @Test
    public void shouldReturnTrueIfNumberOfSetasExactlySameAsAvailableSeats() throws Exception {
        Integer numberOfSeats = 30;
        Assert.assertTrue(flightInfo.canBook(numberOfSeats));
    }

    @Test
    public void shouldReturnFalseIfNumberOfSetasCanNotBeBooked() throws Exception {
        Integer numberOfSeats = 40;
        Assert.assertFalse(flightInfo.canBook(numberOfSeats));
    }

    @Test
    public void shouldHaveArrivalAndDeparture() throws Exception {
        Calendar departure = new GregorianCalendar(2016,4,10, 9, 10, 0);
        Calendar arrival = new GregorianCalendar(2016,4,10, 11, 10, 0);
        Flight flight = new Flight("F001",source, dest, plane, departure, arrival);
        Assert.assertEquals(departure, flight.getDepartureTime());
        Assert.assertEquals(arrival, flight.getArrivalTime());
    }

    @Test(expected=Exception.class)
    public void DepartureDateCannotBeGreaterOrEqualToArrivalTime() throws Exception {
        Calendar departure = new GregorianCalendar(2016,5,10, 9, 10, 0);
        Calendar arrival = new GregorianCalendar(2016,4,10, 11, 10, 0);
        new Flight("F001", source, dest, plane, departure, arrival);
    }

    @Test
    public void getSeatsByClass()
    {
        Assert.assertEquals(10,flightInfo.getAvailableSeatsByClass("Business Class"));
        Assert.assertEquals(21,flightInfo.getAvailableSeatsByClass("First Class"));
        Assert.assertEquals(103,flightInfo.getAvailableSeatsByClass("Economy Class"));
    }
}
