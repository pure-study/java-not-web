package net.will.javatest.basicconcept;

public class FatherClazz {
    public FatherClazz() {
        System.out.println("This is in FatherClazz.");
    }
    
    public FatherClazz(String arg) {
        System.out.println(String.format("This is in FatherClazz Constructor with argument: %s", arg));
    }
}
