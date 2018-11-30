package net.will.javatest.basicconcept.jdk8;

public interface InterfaceWithDefaultImpl {
    public void firstMethod();
    
    public default String secondMethod() {
        return "Run me in JDK1.8+";
    }
}
