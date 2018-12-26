package net.will.javatest.basicconcept.jdk9;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface PrivateMethodsInInterface {
    static final Logger logger = LoggerFactory.getLogger(PrivateMethodsInInterface.class);
    
    default String createUuid() {
        StringBuilder uuid = new StringBuilder(prefixId()).append(LocalDateTime.now());
        
        logInfoUuid(uuid.toString());
        return prefixId();
    }
    
    private String prefixId() {
        return "prefix-";
    }
    
    private static void logInfoUuid(String uuid) {
        logger.info(uuid);
    }
}
