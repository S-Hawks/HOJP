package dev.faiaz.java_functional_programming;

import java.util.function.Function;

public class ScopesProblem {

    public static Function<Integer, Integer> counter() {
        int count = 0;
        Function<Integer, Integer> increment = x -> count + 1;
        return increment;
    }
    public static void main(String[] args) {
        Function<Integer, Integer> counter = ScopesProblem.counter();
        System.out.println(counter.apply(0));
        System.out.println(counter.apply(0));
    }
}
