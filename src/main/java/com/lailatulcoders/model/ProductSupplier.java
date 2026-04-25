package com.lailatulcoders.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_supplier")
public class ProductSupplier {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "supplier_price")
    private Double supplierPrice;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public void setId(int id) { this.id = id; }
    public void setSupplierPrice(Double supplierPrice) { this.supplierPrice = supplierPrice; }
    public void setProduct(Product product) { this.product = product; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }

    public int getId() { return id; }
    public Double getSupplierPrice() { return supplierPrice; }
    public Product getProduct() { return product; }
    public Supplier getSupplier() { return supplier; }
}
