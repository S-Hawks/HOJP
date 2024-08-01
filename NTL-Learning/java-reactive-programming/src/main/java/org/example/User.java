package org.example;

public class User {
    private Integer id;

    private String firstname;

    private String lastname;

    public User(Integer id, String firstname, String lastname){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getFirstname(){
        return this.firstname;
    }
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getLastname(){
        return this.lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName='" + firstname + '\'' + ", lastName='" + lastname + '\'' + '}';
    }
}
