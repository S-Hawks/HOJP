import java.util.Scanner;

public class Array {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myInteger = getIntegers(5);
        for(int i=0; i < myInteger.length; i++){
            System.out.println("Element" + i + ", typed value was " + myInteger[i]);
        }
        System.out.println("The average is " + getAverage(myInteger));
    }

    public static int[] getIntegers(int number){
        System.out.println("Enter " + number + " integer value. \r");

        int[] value = new int[number];

        for(int i=0; i < value.length; i++){
            value[i] = scanner.nextInt();
        }
        return value;
    }
    public static double getAverage(int[] array){
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return (double) sum/ (double)array.length;
    }
}
