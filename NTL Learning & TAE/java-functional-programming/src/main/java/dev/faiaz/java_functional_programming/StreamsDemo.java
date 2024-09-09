package dev.faiaz.java_functional_programming;

import java.util.List;
import java.util.stream.Stream;

public class StreamsDemo {

    public static void main(String[] args) {
        List<String> names = List.of("Foo", "Bar", "Baz");
        Stream<String> stream = names.stream();

        stream.forEach(System.out::println);
    }

}
