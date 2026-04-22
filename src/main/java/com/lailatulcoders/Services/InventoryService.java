package com.lailatulcoders.Services;

import com.lailatulcoders.DTO.Product;

public interface InventoryService {
    boolean needsRestock(Product product); // For now just compare stockLevel and restockThreshold to see if should restock. Later should implement the AI agent
    void addStock(Product product, int quantity); // Buy product. Quantity can just be any random number we set it to. Later should be AI agent determining the amount
    void removeStock(Product product, int quantity); // Dunno if we wanna implement this. basically updates stockLevel after each sale. Probably should do this lol
}