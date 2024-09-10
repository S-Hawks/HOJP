package dev.faiaz.java_functional_programming;

import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        Stream<String> names = Stream.of("apple", "banana", "mango", "strawberry");

        //Peek operator mainly use for debugging purpose.if developer want to see what is returning after eg: map, filter, limit etc operator
        //it's a way to use System.out.println into stream operator to see line by line what's happening
        names.map(String::toUpperCase)
                .peek(str -> System.out.println("Peek element: " + str))
                .filter(name -> name.length() < 6)
                .forEach(System.out::println);

        //If we remove terminal operator #ref-> note_8 stream will not work
        //To try this just remove "forEach" above code


        //TODO: distinct and sort
        Stream<Integer> numbers = Stream.of(1, 2, 9 ,3,4,5,6,7,8,9,10);
        numbers.distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
