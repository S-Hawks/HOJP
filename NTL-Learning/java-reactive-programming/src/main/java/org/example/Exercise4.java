package org.example;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {
    public static void main(String[] args) throws IOException {
        //Use ReactiveSources.intNumberMono()


        //Print the value from intNumberMono when it emits
        //TODO:First Example
        ReactiveSources.intNumberMono().subscribe(number -> System.out.println(number));

        //Get the value from the mono into an integer variable
        //TODO:Second Example
        Optional<Integer> number = ReactiveSources.intNumberMono().blockOptional();
        Integer number1 = ReactiveSources.intNumberMono().block();
        User foo = ReactiveSources.userMono().block();

        //All about subscriber method && how many lambda they are excepting as argument..
        //Below example it receiving 3 argument.
        //TODO:Third Example
        ReactiveSources.intNumberMono().subscribe(
                number3 -> System.out.println(number3),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );

        System.out.println("Press any key to end");
        System.in.read();
    }
}
