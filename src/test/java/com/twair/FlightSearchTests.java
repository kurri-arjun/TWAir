package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class FlightSearchTests {
    private String source;
    private String destination;
    private Calendar departure;
    private Calendar arrival;
    private FlightSearch allFlights;

    @Before
    public void setUp() throws Exception {
        source = "TestSource";
        destination = "TestDestination";
        departure = new GregorianCalendar(2016,3,10, 9, 10, 0);
        arrival = new GregorianCalendar(2016,3,10, 10, 10, 0);

        TravellingClass bussinessClass = new TravellingClass("Business Class", 15, 10000);
        TravellingClass economyClass = new TravellingClass("Economy Class", 195, 6000);
        TravellingClass firstClass = new TravellingClass("First Class", 15, 15000);
        List<TravellingClass> classInfo= new ArrayList<>();
        classInfo.add(bussinessClass);
        classInfo.add(economyClass);
        classInfo.add(firstClass);

        Plane plane1 = new Plane("type1", 10);
        Flight flight1 = new Flight("F001", source, destination, plane1, new GregorianCalendar(2016,3,10, 9, 10, 0), new GregorianCalendar(2016,3,10, 11, 10, 0));
        flight1.setClassesAndSeatsInfo(classInfo);
        Flight flight2 = new Flight("F002", "TestSource1", destination, plane1, new GregorianCalendar(2016,4,10, 9, 10, 0), new GregorianCalendar(2016,4,10, 11, 10, 0));
        Flight flight3 = new Flight("F003", source, destination, plane1, new GregorianCalendar(2016,4,11, 9, 10, 0), new GregorianCalendar(2016,4,11, 11, 10, 0));
        flight3.setClassesAndSeatsInfo(classInfo);
        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
        allFlights = new FlightSearch(flightList);
    }

    @Test
    public void shouldReturnListOfFlightsForMatchingSourceDestination() throws Exception {
        List<Flight> flights = allFlights.byLocation(source, destination).getFlightList();
        Assert.assertEquals(source, flights.get(0).getSource());
        Assert.assertEquals(destination, flights.get(0).getDestination());
        Assert.assertEquals(source, flights.get(1).getSource());
        Assert.assertEquals(destination, flights.get(1).getDestination());
        Assert.assertEquals(2, flights.size());
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldMandateSource() throws Exception {
        allFlights.byLocation(null, destination);
    }

    @Test(expected=IllegalArgumentException.class)
    public void sourceCannotBeEmpty() throws Exception {
        allFlights.byLocation("", destination);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldMandateDestination() throws Exception {
        allFlights.byLocation(source, null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void destinationCannotBeEmpty() throws Exception {
        allFlights.byLocation(source, "");
    }

    @Test
    public void shouldFilterByAvailableSeats() throws Exception {
        int numberOfSeats = 11;
        List<Flight> matchingFlights = allFlights.byAvailableSeats(numberOfSeats).getFlightList();
        Assert.assertEquals(0, matchingFlights.size());
    }

    @Test(expected=IllegalArgumentException.class)
    public void numberOfSeatsCannotBeNegative() throws Exception {
        allFlights.byAvailableSeats(-10);
    }

    @Test
    public void testSearchSeatsByClass()
    {
        List<Flight> matchingFlights = allFlights.searchSeatsByClass("Economy Class", 10).getFlightList();
        Assert.assertEquals(2, matchingFlights.size());
    }

    @Test
    public void getTotalTicketPrice() throws Exception {
        int price = allFlights.getTotalTicketPrice("Economy Class",2);
        Assert.assertEquals(12000, price);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTotalTicketPriceWhenNegativeSeatsGiven() throws Exception {
        int price = allFlights.getTotalTicketPrice("Economy Class",-2);
    }
}
