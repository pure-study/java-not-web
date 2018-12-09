package net.will.javatest.basicconcept.jdk8;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiamondProblemTest {
    @Test
    public void testDiamondProblem() {
        MyClass obj = new MyClass();
        obj.log("something");
        
        System.out.println(obj.toString());
        assertNotNull(obj.toString());
    }
}
