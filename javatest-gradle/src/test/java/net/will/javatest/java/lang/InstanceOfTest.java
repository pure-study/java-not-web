package net.will.javatest.java.lang;

import static org.junit.Assert.*;

import org.junit.Test;

public class InstanceOfTest {

    @Test
    public void testInstanceOf_NotNull() {
        String s = "s";
        assertTrue(s instanceof String);
    }
    
    @Test
    public void testInstanceOf_Null() {
        String s = null;
        assertFalse(s instanceof String);
    }

}
