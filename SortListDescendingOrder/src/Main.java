import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myInteger = getInteger(5);
        int[] sorted = sortInteger(myInteger);
        printArray(sorted);

    }

    public static int[] getInteger(int number){
        int[] value = new int[number];
        System.out.println("Enter " + number + "integer value:\r");
        for(int i = 0; i < value.length; i++){
            value[i] = scanner.nextInt();
        }
        return value;
    }
    public static int[] sortInteger(int[] number){
        int temp;
        for(int i = 0; i < number.length; i++){
            for(int j = i; j < number.length; j++)
                if(number[i] < number[j]){
                    temp = number[i];
                    number[i] = number[j];
                    number[j] = temp;
                }
        }
        return number;
    }
    public static void printArray(int[] number){
        //System.out.println(Arrays.toString(number));
        for(int i = 0; i < number.length; i++){
            System.out.println("Element " + i + "Contents " + number[i]);
        }
    }
}
