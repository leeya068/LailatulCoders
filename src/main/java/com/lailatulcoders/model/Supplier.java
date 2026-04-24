package com.lailatulcoders.model;

public class Supplier {
    private int id;
    private String name;
    private double price;
    private int leadTime; // shipping speed. probs in days.

    public void setId(int id) { this.id = id; }
    public void setString(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setLeadTime(int leadTime) { this.leadTime = leadTime; }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getLeadTime() { return leadTime; }
}