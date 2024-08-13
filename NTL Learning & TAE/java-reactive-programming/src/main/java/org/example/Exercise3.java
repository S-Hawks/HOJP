package org.example;

import java.io.IOException;
import java.util.List;

public class Exercise3 {
    public static void main(String[] args) throws IOException {
        //Use ReactiveSource.intNumberFlux()

        //Get all numbers in the ReactiveSources.intNumberFlux stream
        //into a list and print the list and list size

       List<Integer> numbers =  ReactiveSources.intNumberFlux().toStream().toList();
        System.out.println("List is " + numbers);
        System.out.println("Size " + numbers.size());


        System.out.println("press  a key to end");
        System.in.read();

    }
}
