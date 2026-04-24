package com.lailatulcoders.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lailatulcoders.model.Product;
import com.lailatulcoders.model.Supplier;
import com.lailatulcoders.service.SupplierService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    // productId: list of suppliers
    private Map<Integer, List<Supplier>> supplierDB = new HashMap<>();

    // Optional: method to add suppliers (for testing/demo)
    @Override
    public void addSupplier(Product product, Supplier supplier) {
        supplierDB.computeIfAbsent(product.getId(), k -> new ArrayList<>()).add(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers(Product product) {
        return supplierDB.getOrDefault(product.getId(), new ArrayList<>());
    }

    @Override
    public Supplier getBestSupplier(Product product) {
        List<Supplier> suppliers = supplierDB.get(product.getId());

        if (suppliers == null || suppliers.isEmpty()) {
            throw new RuntimeException("No suppliers found for product: " + product.getId());
        }

        Supplier bestSupplier = null;
        double bestScore = Double.MAX_VALUE;

        for (Supplier supplier : suppliers) {
            // Simple weightage formula
            double score = calculateScore(supplier);

            if (score < bestScore) {
                bestScore = score;
                bestSupplier = supplier;
            }
        }

        return bestSupplier;
    }

    // Weightage formula
    private double calculateScore(Supplier supplier) {
        double priceWeight = 0.7;
        double leadTimeWeight = 0.3;

        return (supplier.getPrice() * priceWeight) + (supplier.getLeadTime() * leadTimeWeight);
    }
}
