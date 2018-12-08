package net.will.javatest.basicconcept.jdk7;

import static org.junit.Assert.*;

import org.junit.Test;

public class SwitchStringsTest {
    @Test
    public void testGetShortNameOfWeekDay() {
        SwitchStrings obj = new SwitchStrings();
        assertTrue( "Mon".equals(obj.getShortNameOfWeekDay("Monday")) );
        assertTrue( "Sat".equals(obj.getShortNameOfWeekDay("Saturday")) );
        
        assertTrue( "".equals(obj.getShortNameOfWeekDay("typo")) );
    }
}
