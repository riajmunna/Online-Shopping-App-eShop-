package com.example.eShop;

public class User_Registration {
    String Name, Email, Password;

    public User_Registration(){

    }
    public User_Registration(String Name, String Email, String Password){
        this.Name = Name;
        this.Password = Password;
        this.Email = Email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}