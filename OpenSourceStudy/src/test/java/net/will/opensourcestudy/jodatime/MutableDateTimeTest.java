package net.will.opensourcestudy.jodatime;

import static org.junit.Assert.*;

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

}
