package com.lailatulcoders.model;

public class Order {
    private int id;
    private int productId;
    private int supplierId;
    private int quantity;
    private String status;

    public void setId(int id) { this.id = id; }
    public void setProductId(int productId) { this.productId = productId; }
    public void setSupplierId(int supplierId) { this.supplierId = supplierId; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setStatus(String status) { this.status = status; }

    public int getId() { return id; }
    public int getProductId() { return productId; }
    public int getSupplierId() { return supplierId; }
    public int getQuantity() { return quantity; }
    public String getStatus() { return status; }
}