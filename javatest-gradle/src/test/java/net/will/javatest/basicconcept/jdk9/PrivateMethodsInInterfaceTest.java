package net.will.javatest.basicconcept.jdk9;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrivateMethodsInInterfaceTest implements PrivateMethodsInInterface {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    public void logInfo(String uuid) {
        logger.info(uuid);
    }
    
    @Test
    public void testCreateUuid() {
        String uuid = createUuid();
        assertNotNull(uuid);
    }
}
