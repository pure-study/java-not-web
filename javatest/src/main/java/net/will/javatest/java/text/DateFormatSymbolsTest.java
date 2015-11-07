package net.will.javatest.java.text;

import java.text.DateFormatSymbols;

public class DateFormatSymbolsTest {

    public static void main(String[] args) {
        for (String mon : new DateFormatSymbols().getMonths()) {
            System.out.println(mon);
        }
        System.out.println("=================");
        for (String mon : new DateFormatSymbols().getShortMonths()) {
            System.out.println(mon);
        }
    }

}
