package net.will.javatest.java.lang;

/**
 * Expect 2 false in JDK 1.6.
 * Expect true + false in JDK 1.7.
 */
public class StringInternTest {

    public static void main(String[] args) {
        String str1 = new StringBuilder("Computer").append(" Science").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

}
