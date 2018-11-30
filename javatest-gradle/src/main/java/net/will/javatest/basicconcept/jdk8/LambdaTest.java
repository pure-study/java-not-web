package net.will.javatest.basicconcept.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {
    
    public static void main(String[] args) {
        testLamda1();
        System.out.println("======================");
        testLamda2();
    }
    
    public static void testLamda1() {
        List<String> list = Arrays.asList("aaa", "fsa", "ser", "eere");
        Collections.sort(list, (Comparator<? super String>) (String a, String b) -> {
            return b.compareTo(a);
        });
        for (String string : list) {
            System.out.println(string);
        }
    }
    
    public static void testLamda2() {
        List<String> list = Arrays.asList("aaa", "fsa", "ser", "eere");
        Collections.sort(list, (a, b) -> b.compareTo(a));
        for (String string : list) {
            System.out.println(string);
        }
    }
}
