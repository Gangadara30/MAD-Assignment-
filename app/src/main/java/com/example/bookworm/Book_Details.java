package com.example.bookworm;

import java.io.Serializable;

public class Book_Details implements Serializable {
    private String bname;
    private String bdiscrip;
    private String bprice;
    private String name;
    private String description;
    private String price;

    public Book_Details() {
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBdiscrip() {
        return bdiscrip;
    }

    public void setBdiscrip(String bdiscrip) {
        this.bdiscrip = bdiscrip;
    }

    public String getBprice() {
        return bprice;
    }

    public void setBprice(String bprice) {
        this.bprice = bprice;
    }
    public Book_Details(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

