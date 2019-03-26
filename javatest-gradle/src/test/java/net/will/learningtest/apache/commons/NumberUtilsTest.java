package net.will.learningtest.apache.commons;

import static org.junit.Assert.*;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

public class NumberUtilsTest {
    @Test
    public void testIsNumber() {
        assertTrue(NumberUtils.isNumber("100"));
        assertTrue(NumberUtils.isNumber("-100"));
        assertTrue(NumberUtils.isNumber("1.01"));
    }
    
    @Test
    public void testIsNumber_withQualifier() {
        assertTrue(NumberUtils.isNumber("0x100"));
        assertTrue(NumberUtils.isNumber("-100L"));
    }
}
