package dev.faiaz.java_functional_programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamsDemo {

    public static void main(String[] args) throws IOException {
        List<String> names = List.of("Foo", "Bar", "Baz");
        Stream<String> stream = names.stream();

        stream.forEach(System.out::println);

        //Using array
        int[] numbers = { 1, 2, 3, 4, 5};
        Arrays.stream(numbers).forEach(System.out::println);

        //Stream.of
        Stream.of("mango", "banana", "strawberry").forEach(System.out::println);

        //Using built in APIs that return Stream
        Stream<String> lines = Files.lines(Paths.get("README.md"));
        lines.forEach(System.out::println);

        //Using stream generate
        //TODO:Here limit is essential if we dont put limit stream will continuously generate double number
        Stream.generate(new Random()::nextDouble)
                .limit(10)
                .forEach(System.out::println);

        //Using Stream.iterate
        // (it's take 2 argument one starting point another unary(A function take one type of argument and return same type result)
        //TODO: Here limit is also essential
        Stream.iterate(0, x -> x + 2)
                .limit(10)
                .forEach(System.out::println);

        List<Integer> upToNumber = Stream.iterate(0, x -> x + 1).limit(10).toList();
        System.out.println(upToNumber);


        Stream<String> fruitNames = Stream.of("apple", "banana", "mango", "strawberry");
        names.stream().map(String::toUpperCase)
                .limit(2)
                .forEach(System.out::println);
        /*
        Here the above code example have performance issue what why ? ->
        we are limiting 2(that means when we use assembly line operator limit it provide a new stream with 2 element and foreach only print 2 element)
        but converting all stream element to uppercase by using map (map also return new stream after applying necessary operation mentioned in stream)
         */
        //So the optimized code could be
        Stream<String> fruitName2 = Stream.of("apple", "banana", "mango", "strawberry");
        fruitName2.limit(2)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

}
