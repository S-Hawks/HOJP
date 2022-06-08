public class Account {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNo;

    public String getAccountNumber() {
        return accountNumber;
    }
    public Account(){
        this("Boob dilan", 2345, "Default value", "Defaul Value", "Default value");
        System.out.println("Empty Constructor");
    }
    public Account(String accountNumber, double balance, String customerName, String email, String phoneN0){
        System.out.println("Account constructor with parameter called");
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance =  balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public void depositFunds(int money){
        this.balance += money;
        System.out.println("Current balance is " + balance);
    }
    public void withdrawFunds(double withdrawalAmount){
        if(balance - withdrawalAmount <= 0){
            System.out.println("Only " + balance + "  available. Withdrawal not processed");
        }else{
            balance -= withdrawalAmount;
            System.out.println("Withdrawal of " + withdrawalAmount + " processed. Remaining balance " + balance);
        }
        }
        public void deposit(double deposit){
            balance += deposit;
            System.out.println("Available balance after deposit: " + balance);
        }
    }
