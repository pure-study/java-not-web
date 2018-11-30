package net.will.javatest.basicconcept.jdk8;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InterfaceWithDefaultImplTest implements InterfaceWithDefaultImpl {
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Override
    public void firstMethod() {
        logger.info("This is a real implementation in the sub-class.");
    }
    
    @Test
    public void testDefaultImplementationOfInterface() {
        InterfaceWithDefaultImplTest obj = new InterfaceWithDefaultImplTest();
        obj.firstMethod();
        logger.info(obj.secondMethod());
        
        assertNotNull(obj.secondMethod());
    }
    
}
