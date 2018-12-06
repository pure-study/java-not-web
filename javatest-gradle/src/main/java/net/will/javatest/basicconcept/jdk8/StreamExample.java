package net.will.javatest.basicconcept.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        for(int i=0; i<120; i++) myList.add(i);
        
        //sequential stream
        Stream<Integer> sequentialStream = myList.stream();
        Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
        highNumsSeq.forEach(p -> System.out.println("High Nums sequential="+p));
        
        //parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();
        Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
        highNums.forEach(p -> System.out.println("High Nums parallel="+p));
    }
}

