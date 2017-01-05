package net.will.javatest.javax.annotation;

import static org.junit.Assert.*;

import org.junit.Test;

public class JavaxAnnotationTest {

    @Test
    public void test() {
        Irrelevant obj = new Irrelevant();
        obj.toString();
        
        assertNotNull("OK, did you see the log?");
    }

}
