package com.twair;

/**
 * Created by sangeeth on 02-04-2016.
 */
public enum SeatTypes {
    BUSINESSCLASS("Business Class"), FIRSTCLASS("First Class"), ECONOMYCLASS("Economy Class");

    private final String className;
    private SeatTypes(String className)
    {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}
