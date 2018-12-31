package net.will.javatest.basicconcept.jdk9;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessHandleTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Test
    public void testCurrent() {
        ProcessHandle currentProcess = ProcessHandle.current();
        logger.debug( String.valueOf(currentProcess.pid()) );
        assertTrue(currentProcess.pid() > 0);
    }
}
