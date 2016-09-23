package net.will.opensourcestudy.powermock;

public class TestObjectWithStatic {
    public static String firstStaticMethod(String param) {
        return param + java.io.File.separator;
    }
    
    public static int secondStaticMethod() {
        return 1;
    }
    
    public static void thirdStaticMethod() {
        // NOP
    }
}
