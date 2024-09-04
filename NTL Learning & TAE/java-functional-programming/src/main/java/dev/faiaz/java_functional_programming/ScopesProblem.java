package dev.faiaz.java_functional_programming;

import java.util.function.Function;

public class ScopesProblem {

    public static int counter() {
        int count = 0;
        Function<Integer, Integer> increment = x -> count + 1;
        return increment.apply(count);
    }
    public static void main(String[] args) {


    }
}
