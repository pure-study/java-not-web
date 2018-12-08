package net.will.javatest.basicconcept.jdk8;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConvertFuncTest {
    @Test
    public void testRegularImplementation() {
        IConvertFunc<String, Integer> obj = new ConvertFuncImpl();
        assertEquals(obj.convert("100"), new Integer(100));
    }

    @Test
    public void testMethodRefImplementation() {
        ConvertFuncImplViaMethodRef obj = new ConvertFuncImplViaMethodRef();
        assertEquals(obj.convertWithIntegerValueOf("100"), new Integer(100));
    }
}
