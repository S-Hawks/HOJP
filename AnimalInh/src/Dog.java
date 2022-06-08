public class Dog extends Animal {

    private int eyes;
    private int legs;
    private String cote;

    public Dog(  int size, int weight, String name, int eyes, int legs, String cote){
        super(1, 1, size, weight, name);
        this.eyes = eyes;
        this.legs = legs;
        this.cote = cote;
    }

    private void chew(){
        System.out.println("Dog.chew() called");
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat() called");
        chew();
//        super.eat();  
    }

    public void walk(){
        System.out.println("Dog.walk() called");
        move(5);
    }
    public void run(){
        System.out.println("dog.run() called");
        move(10);
    }
}
