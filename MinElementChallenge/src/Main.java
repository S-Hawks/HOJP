public class Main {
    public static void main(String[] args) {
        MinElementChallenge element = new MinElementChallenge();
        int[] minimumValue = element.readElement(element.readInteger());
        System.out.println(element.findMin(minimumValue));

    }
}