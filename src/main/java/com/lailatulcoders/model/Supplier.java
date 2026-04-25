package com.lailatulcoders.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private int id;

    @Column(name = "supplier_name")
    private String name;

    @Column(name = "supplier_rating")
    private Double rating;

    @Column(name = "lead_time")
    private Integer leadTime; // shipping speed. probs in days.

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setRating(Double rating) { this.rating = rating; }
    public void setLeadTime(Integer leadTime) { this.leadTime = leadTime; }

    public int getId() { return id; }
    public String getName() { return name; }
    public Double getRating() { return rating; }
    public Integer getLeadTime() { return leadTime; }
}