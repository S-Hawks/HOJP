package dev.faiaz.java_functional_programming;

import java.time.LocalDateTime;
/*
This is a Object Oriented way to pass a behavior.
why functional programming ?
Ans: Here we write interface and implementation to pass just a single line of code
"Hello World"
wouldn't it be nice to pass the behaviour rather than writing so much boilerplate code or interface ?
Functional programming give us the ability to pass only the behavior
* */
public class LimitationOfOOP {


    public static void runner(Task task) {
        System.out.println("Start: " + LocalDateTime.now());
        System.out.println("Hello World");
        System.out.println("End: " + LocalDateTime.now());

    }
    public static void main(String[] args) {
        Task task = new HelloWorld();
        LimitationOfOOP.runner(task);
    }
}
interface Task {
    void run();
}

class HelloWorld implements Task {
    @Override
    public void run() {
        System.out.println("Hello World");
    }
}
