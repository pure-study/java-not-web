package net.will.javatest.java.lang;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathTest {
    
    @Test
    public void testPow() {
        assertEquals(2, Math.pow(2, 1), 0);

        assertEquals(1, Math.pow(2, 0), 0);

        assertEquals(8, Math.pow(2, 3), 0);
    }
    
}
