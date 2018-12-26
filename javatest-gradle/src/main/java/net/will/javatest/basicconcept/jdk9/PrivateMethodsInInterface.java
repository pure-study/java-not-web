package net.will.javatest.basicconcept.jdk9;

import java.time.LocalDateTime;

public interface PrivateMethodsInInterface {
    default String createUuid() {
        StringBuilder uuid = new StringBuilder(prefixId()).append(LocalDateTime.now());
        
        doSomethingStatic(uuid.toString());
        logInfo(uuid.toString());
        return uuid.toString();
    }
    
    void logInfo(String uuid);
    
    private String prefixId() {
        return "prefix-";
    }
    
    private static void doSomethingStatic(String uuid) {
        System.out.println(String.format("Output of the private static method in the Interface: %s", uuid));
    }
}
