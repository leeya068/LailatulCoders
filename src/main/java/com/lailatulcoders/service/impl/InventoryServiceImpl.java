package com.lailatulcoders.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lailatulcoders.model.Product;
import com.lailatulcoders.service.InventoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private static final Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);
    private Map<Integer, Product> productDB = new HashMap<>();

    @Override
    public void addStock(Product product, int quantity) {
        try {
            if (product == null) {
                throw new RuntimeException("Product cannot be null");
            }

            product.setStockLevel(product.getStockLevel() + quantity);

            logger.info("[STOCK ADDED] Product: {} | Qty: {} | New Stock: {}", product.getId(), quantity, product.getStockLevel());

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

            if (product.getStockLevel() < quantity) {
                throw new RuntimeException("Insufficient stock");
            }

            product.setStockLevel(product.getStockLevel() - quantity);

            logger.info("[STOCK REMOVED] Product: {} | Qty: {} | Remaining: {}", product.getId(), quantity, product.getStockLevel());

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

            boolean result = product.getStockLevel() <= product.getRestockThreshold();

            logger.info("[RESTOCK CHECK] Product: {} | Needs Restock: {}", product.getId(), result);

            return result;

        } catch (Exception e) {
            logger.error("[ERROR RESTOCK CHECK] {}", e.getMessage(), e);
            throw e;
        }
    }
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
