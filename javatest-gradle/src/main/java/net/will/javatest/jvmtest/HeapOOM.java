package net.will.javatest.jvmtest;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    
    static class OOMObject {
    }
    
    public static void main(String[] args) {
        if ( notReadyToGo(args) ) return;
        
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
    
    private static boolean notReadyToGo(String[] args) {
        return args == null || !"go".equals(args[0]);
    }
    
}
