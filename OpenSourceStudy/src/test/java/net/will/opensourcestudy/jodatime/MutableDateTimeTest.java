package net.will.opensourcestudy.jodatime;

import static org.junit.Assert.*;

import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.junit.Test;

public class MutableDateTimeTest {

    @Test
    public void testAddMonths_NegativeParameter_March2February() {
        MutableDateTime mdt1 = new MutableDateTime(2016, 3, 15, 0, 0, 0, 0);
        mdt1.addMonths(-1);
        
        MutableDateTime mdt2 = new MutableDateTime(2016, 2, 15, 0, 0, 0, 0);
        assertTrue(mdt1.equals(mdt2));
    }

    @Test
    public void testAddMonths_NegativeParameter_AcrossYear() {
        MutableDateTime mdt1 = new MutableDateTime(2016, 1, 15, 0, 0, 0, 0);
        mdt1.addMonths(-1);
        
        MutableDateTime mdt2 = new MutableDateTime(2015, 12, 15, 0, 0, 0, 0);
        assertTrue(mdt1.equals(mdt2));
    }

    @Test
    public void testDayOfMonthProperty_RoundFloor() {
        MutableDateTime mdt1 = new MutableDateTime(2016, 3, 15, 1, 2, 3, 4);
        mdt1.dayOfMonth().roundFloor();
        
        MutableDateTime mdt2 = new MutableDateTime(2016, 3, 15, 0, 0, 0, 0);
        assertTrue(mdt1.equals(mdt2));
    }

    @Test
    public void testDayOfMonthProperty_RoundCeiling() {
        MutableDateTime mdt1 = new MutableDateTime(2016, 3, 15, 1, 2, 3, 4);
        mdt1.dayOfMonth().roundCeiling();
        
        MutableDateTime mdt2 = new MutableDateTime(2016, 3, 16, 0, 0, 0, 0);
        assertTrue(mdt1.equals(mdt2));
    }

    @Test
    public void testSetTime() {
        MutableDateTime mdt1 = new MutableDateTime(2016, 3, 15, 1, 2, 3, 4);
        mdt1.setTime(4, 3, 2, 1);
        
        MutableDateTime mdt2 = new MutableDateTime(2016, 3, 15, 4, 3, 2, 1);
        assertTrue(mdt1.equals(mdt2));
    }

    @Test
    public void testConstructor_Args_Object() {
        MutableDateTime mdt1 = new MutableDateTime("1970-01-01T00:00:00");
        
        MutableDateTime mdt2 = new MutableDateTime(1970, 1, 1, 0, 0, 0, 0);
        assertTrue(mdt1.equals(mdt2));
    }

    @Test
    public void testConstructor_Args_Long_Zero_DateTimeZone() {
        MutableDateTime mdt1 = new MutableDateTime(0, DateTimeZone.UTC);
        
        MutableDateTime mdt2 = new MutableDateTime(1970, 1, 1, 0, 0, 0, 0, DateTimeZone.UTC);
        assertTrue(mdt1.equals(mdt2));
    }

    @Test
    public void testConstructor_Args_Long_Zero() {
        MutableDateTime mdt1 = new MutableDateTime(0);
        MutableDateTime mdt2 = new MutableDateTime(1970, 1, 1, 0, 0, 0, 0, DateTimeZone.UTC);
        assertEquals(mdt1.getMillis(), mdt2.getMillis());
    }

    @Test
    public void testEquals() {
        MutableDateTime mdt1 = new MutableDateTime(0);
        MutableDateTime mdt2 = new MutableDateTime(1970, 1, 1, 0, 0, 0, 0, DateTimeZone.UTC);
        
        // the milliseconds are the same, but "equals()" returns false:
        assertFalse(mdt1.equals(mdt2));
    }

}
