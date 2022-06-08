public class Main {
    public static void main(String[] args){
        VipCustomer person1 = new VipCustomer();
        System.out.println(person1.getName());
        System.out.println(person1.getCredit());
        System.out.println(person1.getEmail());

        VipCustomer person2 = new VipCustomer("John Doe", 300);
        System.out.println(person2.getName());
        System.out.println(person2.getCredit());
        System.out.println(person2.getEmail());

        VipCustomer person3 = new VipCustomer("Samir Mss", 50000, "samir@gmail.com");
        System.out.println(person3.getName());
        System.out.println(person3.getCredit());
        System.out.println(person3.getEmail());
    }
}
