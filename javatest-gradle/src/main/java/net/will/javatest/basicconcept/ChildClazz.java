package net.will.javatest.basicconcept;

public class ChildClazz extends FatherClazz {
    
    public ChildClazz() {
        super("pass-in-param-from-child");
        System.out.println("This is in ChildClazz.");
    }
    
    public static void main(String[] args) {
        ChildClazz obj = new ChildClazz();
        System.out.println("Let's see " + obj.toString());
    }
    
}
