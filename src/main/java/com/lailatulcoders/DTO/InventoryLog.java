package com.lailatulcoders.DTO;

public class InventoryLog {
    private int productId;
    private int change;
    private int timestamp;

    public void setProductId(int productId) { this.productId = productId; }
    public void setChange(int change) { this.change = change; }
    public void setTimestamp(int timestamp) { this.timestamp = timestamp; }

    public int getProductId() { return productId; }
    public int getChange() { return change; }
    public int getTimestamp() { return timestamp; }
}