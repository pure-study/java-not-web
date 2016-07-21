package net.will.javatest.java.lang;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringTest {

    @Test
    public void test_replaceAll() {
        String src = "before ${to_replace} after";
        String dest = "before middle after";
        assertTrue( dest.equals(src.replaceAll("\\$\\{to_replace\\}", "middle")) );
    }

}
