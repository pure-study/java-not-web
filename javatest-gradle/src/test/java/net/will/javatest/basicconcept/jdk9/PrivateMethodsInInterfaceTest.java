package net.will.javatest.basicconcept.jdk9;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrivateMethodsInInterfaceTest implements PrivateMethodsInInterface {
    @Test
    public void testCreateUuid() {
        String uuid = createUuid();
        assertNotNull(uuid);
    }
}
