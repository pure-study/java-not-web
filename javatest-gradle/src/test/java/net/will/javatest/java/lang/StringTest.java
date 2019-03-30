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
    
    @Test
    public void test_format() {
        String str = String.format("Class string: %s", getClass());
        System.out.println(str);
        assertTrue( str.contains(getClass().getSimpleName()) );
    }
    
    @Test
    public void test_substring() {
        String str = "0123456789".substring(0);
        System.out.println(str);
        assertTrue( str.equals("0123456789") );
        
        str = "0123456789".substring(1);
        System.out.println(str);
        assertTrue( str.equals("123456789") );
        
        str = "0123456789".substring(0, 1);
        System.out.println(str);
        assertTrue( str.equals("0") );
        
        str = "0123456789".substring(0, 0);
        System.out.println(str);
        assertTrue( str.isEmpty() );
    }

}
