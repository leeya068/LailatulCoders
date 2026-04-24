package com.lailatulcoders.model;

public class Product {
    private int id;
    private String name;
    private int stockLevel;
    private int restockThreshold;

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setStockLevel(int stockLevel) { this.stockLevel = stockLevel; }
    public void setRestockThreshold(int restockThreshold) { this.restockThreshold = restockThreshold; }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getStockLevel() { return stockLevel; }
    public int getRestockThreshold() { return restockThreshold; }
}
