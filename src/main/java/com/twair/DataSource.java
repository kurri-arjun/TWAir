package com.twair;

import java.util.*;

public class DataSource {
    final private static DataSource dataSource = new DataSource();
    public static DataSource instance() {
        return dataSource;
    }

    public List<String> fetchLocations() {
        List<String> locations = new ArrayList<String>();
        locations.add("Hyderabad");
        locations.add("Bangalore");
        return locations;
    }

    public List<String> fetchTravellingClass() {
        List<String> travellingClass = new ArrayList<String>();
        travellingClass.add("First Class");
        travellingClass.add("Business Class");
        travellingClass.add("Economy Class");
        return travellingClass;
    }

    public List<Plane> fetchPlanes() {
        List<Plane> planes = new ArrayList<>();
        planes.add(new Plane("Boeing777-200LR(77L)", 195));
        planes.add(new Plane("Airbus A319 V2", 144));
        planes.add(new Plane("Airbus A321", 152));
        return planes;
    }

    public FlightSearch fetchFlights() throws Exception {
        List<Flight> flightList = new ArrayList<>();
        List<Plane> planes = fetchPlanes();
        List<String> locations = fetchLocations();

        TravellingClass bussinessClass = new TravellingClass("Business Class", 15, 10000);
        TravellingClass economyClass = new TravellingClass("Economy Class", 15, 6000);
        TravellingClass firstClass = new TravellingClass("First Class", 15, 15000);
        List<TravellingClass> classInfo= new ArrayList<>();
        classInfo.add(bussinessClass);
        classInfo.add(economyClass);
        classInfo.add(firstClass);

        Flight flight1 = new Flight("F001", locations.get(0), locations.get(1), planes.get(0), new GregorianCalendar(2016,3,10, 9, 10, 0), new GregorianCalendar(2016,3,10, 9, 12, 0));
        flight1.setClassesAndSeatsInfo(classInfo);
        Flight flight2 = new Flight("F002", locations.get(0), locations.get(1), planes.get(1), new GregorianCalendar(2016,3,11, 9, 10, 0), new GregorianCalendar(2016,3,11, 9, 12, 0));
        Flight flight3 = new Flight("F003", locations.get(0), locations.get(1), planes.get(2), new GregorianCalendar(2016,3,12, 9, 10, 0), new GregorianCalendar(2016,3,12, 9, 12, 0));
        flight3.setClassesAndSeatsInfo(classInfo);

        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
        FlightSearch allFlights = new FlightSearch(flightList);
        return allFlights;
    }
}
