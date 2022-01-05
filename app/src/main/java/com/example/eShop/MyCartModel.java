package com.example.eShop;

public class MyCartModel {
    String description;
    String code;
    String price;
    String date;

    public  MyCartModel(){

    }
    public MyCartModel(String description, String code, String price, String date) {
        this.description = description;
        this.code = code;
        this.price = price;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
