public class VipCustomer {
    private String name;
    private int credit;
    private String email;

    public VipCustomer(){
        this("Default Value", 0, "Default value");
    }
    public VipCustomer(String name, int credit){
        this(name, credit, "Default value");
    }

    public VipCustomer(String name, int credit, String email){
        this.name = name;
        this.credit = credit;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public String getEmail() {
        return email;
    }
}
