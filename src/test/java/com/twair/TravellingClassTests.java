package com.twair;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sangeeth on 01-04-2016.
 */
public class TravellingClassTests
{
    @Test
    public void testTravellingClass()
    {
        TravellingClass cls = new TravellingClass("Business Class", 15, 6000);
        Assert.assertEquals("Business Class", cls.getTravellingClass());
        Assert.assertEquals(15, cls.getAvailableSeats());
        Assert.assertEquals(6000, cls.getPrice());
    }
}
