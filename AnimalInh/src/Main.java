public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal(1,1,5,10, "Animal");

        Dog dog = new Dog(10,30, "Yorke", 2, 4, "long silky");
        dog.eat();
        dog.walk();
    }

}
