package net.will.javatest.java.lang;

public class ClassLoaderVsClassForName {

    public static void main(String[] args) {
        try {
            System.out.println("Using Class.forName():");
            Class.forName("net.will.javatest.java.lang.ClassToLoad");
            
            System.out.println("###########################");

            System.out.println("Using ClassLoader:");
            ClassLoader.getSystemClassLoader().loadClass("net.will.javatest.java.lang.ClassToLoad");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
