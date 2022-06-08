public class Main {
    public static void main(String[] args) {
        Account boobAccount = new Account();
        boobAccount.setAccountNumber("1234");
        boobAccount.setCustomerName("Boom Dilan");
        boobAccount.setPhoneNo("012343434");
        boobAccount.setEmail("boob@gmail.com");
        boobAccount.setBalance(5000);
        boobAccount.withdrawFunds(100.0);
        boobAccount.deposit(50.0);
        boobAccount.withdrawFunds(51);
        System.out.println(boobAccount.getEmail());
    }
}
