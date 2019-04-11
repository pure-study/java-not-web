package net.will.javatest.java.lang;

public class ClassToLoad {
    static {
        System.out.println("Executing a static block");
    }
    
    public static String staticField = staticMethod();
    
    public static String staticMethod() {
        System.out.println("Executing a static method");
        return "Assigning value to a static field";
    }
}
