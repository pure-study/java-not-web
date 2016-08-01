package net.will.javatest.java.lang;

import static org.junit.Assert.*;

import java.text.MessageFormat;

import org.junit.Test;

public class MessageFormatTest {

    @Test
    public void test_Basic() {
        String oneParam = "1st";
        String anotherParam = "2nd";
        String result = MessageFormat.format("Have fun with {0} and {1}", oneParam, anotherParam);
        
        assertTrue("Have fun with 1st and 2nd".equals(result));
    }

    @Test
    public void test_WithDuplication() {
        String oneParam = "1st";
        String anotherParam = "2nd";
        String result = MessageFormat.format("Have fun with {0}, {1} and {1}", oneParam, anotherParam);
        
        assertTrue("Have fun with 1st, 2nd and 2nd".equals(result));
    }

    @Test
    public void test_WithShuffle() {
        String oneParam = "1st";
        String anotherParam = "2nd";
        String result = MessageFormat.format("Have fun with {1}, {0}, {0} and {1}", oneParam, anotherParam);
        
        assertTrue("Have fun with 2nd, 1st, 1st and 2nd".equals(result));
    }

}
