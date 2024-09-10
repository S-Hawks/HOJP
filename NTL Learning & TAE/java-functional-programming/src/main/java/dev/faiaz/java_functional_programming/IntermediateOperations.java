package dev.faiaz.java_functional_programming;

import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(1, 2,3,4,5,6,7,8,9,10);

        Stream<Integer> limitedStream = numbers.limit(10);

        limitedStream.forEach(System.out::println);

         numbers = Stream.of(1, 2,3,4,5,6,7,8,9,10);
         Stream<Integer> evenStream = numbers.filter(x -> x % 2 == 0);
         Stream<Integer> first2Evens = evenStream.limit(2);
         evenStream.forEach(System.out::println);
    }


}
