package net.will.javatest.basicconcept;

import java.util.ArrayList;
import java.util.List;

public class ForLoopOnNullCollection {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (String str : list) {
            System.out.println(str);
        }
        
        // illegal:
//        list = null;
//        for (String str : list) {
//            System.out.println(str);
//        }
    }

}
