package com.lailatulcoders.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;
    
    @Column(name = "product_name")
    private String name;

    @Column(name = "stock_level")
    private Integer stockLevel;

    @Column(name = "restock_threshold")
    private Integer restockThreshold;

    public Product() {}

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setStockLevel(Integer stockLevel) { this.stockLevel = stockLevel; }
    public void setRestockThreshold(Integer restockThreshold) { this.restockThreshold = restockThreshold; }

    public int getId() { return id; }
    public String getName() { return name; }
    public Integer getStockLevel() { return stockLevel; }
    public Integer getRestockThreshold() { return restockThreshold; }
}
