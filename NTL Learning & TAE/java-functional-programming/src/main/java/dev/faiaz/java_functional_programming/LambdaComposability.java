package dev.faiaz.java_functional_programming;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.function.BiConsumer;
import java.util.function.UnaryOperator;

public class LambdaComposability {
    public static void operationLogger(UnaryOperator<Integer> operation){
        System.out.println("Start: " + LocalDateTime.now());
        operation.apply(10);
        System.out.println("End: " + LocalDateTime.now());
    }

    public static void main(String[] args) {
      UnaryOperator<Integer> increment  = x-> x + 1;

      //Lambda calling lambda
        Runnable logStart = () -> System.out.println("Start: " + LocalDateTime.now());
        Runnable logEnd = () -> System.out.println("End: " + LocalDateTime.now());
      BiConsumer<UnaryOperator<Integer>, Integer> logger = (operation, number) -> {
//            System.out.println("Start: " + LocalDateTime.now());
          logStart.run();
            operation.apply(number);
//            System.out.println("End: " + LocalDateTime.now());
          logEnd.run();
        };
        logger.accept(x -> x + 1, 10);
    }
}
