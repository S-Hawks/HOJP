package dev.faiaz.java_functional_programming;

import java.util.function.*;

public class JDKFunctionalInterfaces {
    public static void main(String[] args) {

        Function<Integer, Integer> myFunc = x -> x + 1;
        myFunc.apply(10);
        UnaryOperator<Integer> myFunc1 = x -> x + 1; //Note UnaryOperator is a shortcut of Functional interface.
        Function<Integer, String> f2 = num -> "Value is " + num;

        Consumer<String> greeting = name -> System.out.println("Hello " + name);
        greeting.accept("Faiaz");

        Supplier<Double> random = () -> Math.random();
        random.get();


        Predicate<Integer> isEven = num -> num % 2 == 0;
        isEven.test(5);

    }
}
