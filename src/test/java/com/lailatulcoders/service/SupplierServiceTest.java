package com.lailatulcoders.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lailatulcoders.model.Product;
import com.lailatulcoders.model.Supplier;
import com.lailatulcoders.repository.ProductRepository;

@SpringBootTest
class SupplierServiceTest {
    
    private final SupplierService supplierService;
    private final ProductRepository productRepository;

    @Autowired
    SupplierServiceTest(SupplierService supplierService, ProductRepository productRepository) {
        this.supplierService = supplierService;
        this.productRepository = productRepository;
    }

    @Test
    void testAddAndRetrieveSuppliers() {

        Product product = productRepository.findById(1).orElseThrow();

        List<Supplier> list = supplierService.getAllSuppliers(product.getId());
        assertEquals(3, list.size()); 
    }

    @Test
    void testBestSupplier() {

        Product product = productRepository.findById(1).orElseThrow();

        Supplier best = supplierService.getBestSupplier(product.getId());
        assertEquals(1, best.getId());

    }
}
