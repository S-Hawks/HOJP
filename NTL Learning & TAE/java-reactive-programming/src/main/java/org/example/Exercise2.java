package org.example;

import java.io.IOException;

public class Exercise2 {
    public static void main(String[] args) {

        //Use ReactiveSources.intNumberFlux() and ReactiveSources.userFlux()


        //Print of all numbers in the ReactiveSources.intNumberFlux stream
        //Tips:: subscribe is similar to foreach loop
//        ReactiveSources.intNumberFlux().subscribe(e -> System.out.println(e));

        //Print all users in the ReactiveSources.userFlux steam

        ReactiveSources.userFlux().subscribe(user -> System.out.println(user));

        //print all user in the ReactiveSources.userFlux stream.


        System.out.println("Press a key to end");
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

