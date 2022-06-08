import java.util.Scanner;

public class MinElementChallenge {

    public static int readInteger(){
        System.out.println("How many clements?: ");
        int num = scanner.nextInt();
        return num;
    }
    private static Scanner scanner = new Scanner(System.in);

    public int[] readElement(int number){
        int[] array = new int[number];
        for(int i = 0; i < number; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }
    public int findMin(int[] array){
        int min = array[0];
        for(int i= 1; i < array.length; i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
}
