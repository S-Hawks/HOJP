package dev.faiaz.java_functional_programming;

public class LambdaExpressionOverLimitationOfOOP {
    public static void main(String[] args) {
       MathOperation increment = x -> x + 1;
        int result = increment.operation(10);
        System.out.println("Result: " + result);

        MathOperation newLambda = num -> num * 2 + 124;
        System.out.println("New Lambda Result: " + newLambda.operation(20));

    }

}

interface MathOperation{
    int operation(int x);
}
