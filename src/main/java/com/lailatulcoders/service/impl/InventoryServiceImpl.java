package com.lailatulcoders.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lailatulcoders.model.Product;
import com.lailatulcoders.service.InventoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private Map<Integer, Product> productDB = new HashMap<>();

    @Override
    public void addStock(Product product, int quantity) {
        if (product == null) {
            throw new RuntimeException("Product cannot be null");
        }

        product.setStockLevel(product.getStockLevel() + quantity);
    }

    @Override
    public void removeStock(Product product, int quantity) {
        if (product == null) {
            throw new RuntimeException("Product cannot be null");
        }

        if (product.getStockLevel() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }

        product.setStockLevel(product.getStockLevel() - quantity);
    }

    @Override
    public boolean needsRestock(Product product) {
        if (product == null) {
            throw new RuntimeException("Product cannot be null");
        }

        return product.getStockLevel() <= product.getRestockThreshold();
    }
}