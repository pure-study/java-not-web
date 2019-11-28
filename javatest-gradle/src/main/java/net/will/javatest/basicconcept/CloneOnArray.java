package net.will.javatest.basicconcept;

public class CloneOnArray {
    public static void main(String[] args) {
        Object[] elements = new Object[]{"str1", "str2"};
        Object[] el2 = elements.clone();
        
        System.out.println(elements);
        System.out.println(el2);
        System.out.println(el2.length);
        System.out.println(el2[0]);
        System.out.println(el2[1]);
    }
}
