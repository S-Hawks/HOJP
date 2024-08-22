package dev.faiaz.java_functional_programming;

public class Calculator {

    public static int doOperation(IntOperation op, int x, int y){
       return op.doOperation(x, y);
    }
    public static void main(String[] args) {
        IntOperation addition = (x,y) -> x + y;
        IntOperation subtraction = (x,y) -> x - y;
        doOperation(addition, 20, 10);
        doOperation(subtraction, 20, 10);
    }

}

@FunctionalInterface
interface IntOperation{
    int doOperation(int i, int j);
}
