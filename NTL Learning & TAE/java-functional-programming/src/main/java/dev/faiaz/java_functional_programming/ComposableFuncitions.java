package dev.faiaz.java_functional_programming;

import java.util.function.Function;

public class ComposableFuncitions {
    public static void main(String[] args) {
        Function<Integer, Integer> increment = x -> x + 1;
        Function<Integer, Integer> doubleIt = x -> x * 2;

        int i = 10;

        Function<Integer, Integer> combine = increment
                .andThen(doubleIt)
                .andThen(increment);
        System.out.println(combine.apply(i));

        //Situation: We have  string with leading space and trailing space and convert it to Uppercase. we need to remove this spaces, convert to uppercase and print the string
        Function<String, String> trimLeading = String::stripLeading;
        Function<String, String> trimTrailing = String::stripTrailing;
        Function<String, String> upperCase = String::toUpperCase;

        String name = "     storm hawks          ";

        String processName = trimLeading
                .andThen(String::stripTrailing)
                .andThen(upperCase)
                .apply(name);

        System.out.println(processName);

    }
}
