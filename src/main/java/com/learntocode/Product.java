package com.learntocode;

public class Product {
    // create properties for class
    private String Id;
    private String Name;
    private float Price;


    // Constructor to create objects
    public Product(String id, String name, float price) {
        Id = id;
        Name = name;
        Price = price;
    }

    // generate setters and getters for Id,Name,Price
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public float getPrice() {
        return Price;
    }
    public void setPrice(float price) {
        Price = price;
    }



}
