package com.lailatulcoders.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lailatulcoders.model.Product;
import com.lailatulcoders.repository.ProductRepository;
import com.lailatulcoders.service.InventoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private static final Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);
    private final ProductRepository productRepository;

    @Override
    public void addStock(Product product, int quantity) {
        try {
            if (product == null) {
                throw new RuntimeException("Product cannot be null");
            }

            Product productDB = productRepository.findById(product.getId()).orElseThrow(() -> new RuntimeException("Product not found"));

            productDB.setStockLevel(productDB.getStockLevel() + quantity);
            productRepository.save(productDB);

            logger.info("[STOCK ADDED] Product: {} | Qty: {} | New Stock: {}", productDB.getId(), quantity, productDB.getStockLevel());

        } catch (Exception e) {
            logger.error("[ERROR ADD STOCK] {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void removeStock(Product product, int quantity) {
        try {
            if (product == null) {
                throw new RuntimeException("Product cannot be null");
            }

            Product productDB = productRepository.findById(product.getId()).orElseThrow(() -> new RuntimeException("Product not found"));

            if (productDB.getStockLevel() < quantity) {
                throw new RuntimeException("Insufficient stock");
            }

            productDB.setStockLevel(productDB.getStockLevel() - quantity);
            productRepository.save(productDB);

            logger.info("[STOCK REMOVED] Product: {} | Qty: {} | Remaining: {}", productDB.getId(), quantity, productDB.getStockLevel());

        } catch (Exception e) {
            logger.error("[ERROR REMOVE STOCK] {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public boolean needsRestock(Product product) {
        try {
            if (product == null) {
                throw new RuntimeException("Product cannot be null");
            }

            Product productDB = productRepository.findById(product.getId()).orElseThrow(() -> new RuntimeException("Product not found"));

            boolean result = productDB.getStockLevel() <= productDB.getRestockThreshold();

            logger.info("[RESTOCK CHECK] Product: {} | Needs Restock: {}", productDB.getId(), result);

            return result;

        } catch (Exception e) {
            logger.error("[ERROR RESTOCK CHECK] {}", e.getMessage(), e);
            throw e;
        }
    }
}
