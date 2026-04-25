package com.lailatulcoders.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lailatulcoders.model.Product;
import com.lailatulcoders.model.ProductSupplier;
import com.lailatulcoders.model.Supplier;
import com.lailatulcoders.repository.ProductSupplierRepository;
import com.lailatulcoders.service.SupplierService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private static final Logger logger = LoggerFactory.getLogger(SupplierServiceImpl.class);

    // productId: list of suppliers
    private final ProductSupplierRepository productSupplierRepository;

    @Override
    public void addSupplier(Product product, Supplier supplier) {
        ProductSupplier ps = new ProductSupplier();
        ps.setProduct(product);
        ps.setSupplier(supplier);

        productSupplierRepository.save(ps);
    }

    @Override
    public List<Supplier> getAllSuppliers(int productId) {
        List<ProductSupplier> links = productSupplierRepository.findByProduct_Id(productId);
        List<Supplier> suppliers = links.stream().map(ProductSupplier::getSupplier).toList();
    
        logger.info("[GET SUPPLIERS] Product: {} | Count: {}", productId, suppliers.size());
    
        return suppliers;
    }

    @Override
    public Supplier getBestSupplier(int productId) {
        try {
            List<ProductSupplier> links = productSupplierRepository.findByProduct_Id(productId);
            
            if (links.isEmpty()) {
                throw new RuntimeException("No suppliers found for " + productId);
            }

            ProductSupplier best = links.stream().min((a, b) -> Double.compare(score(a), score(b))).orElseThrow();
    
            logger.info("[BEST SUPPLIER] Product: {} | Supplier: {}", productId, best.getSupplier().getName());
    
            return best.getSupplier();
    
        } catch (Exception e) {
            logger.error("[ERROR BEST SUPPLIER] {}", e.getMessage(), e);
            throw e;
        }
    }

    // Weightage formula
    private double score(ProductSupplier ps) {
        double priceWeight = 0.7;
        double leadTimeWeight = 0.3;

        double price = ps.getSupplierPrice();
        double leadTime = ps.getSupplier().getLeadTime();

        return (price * priceWeight) + (leadTime * leadTimeWeight);
    }
}
