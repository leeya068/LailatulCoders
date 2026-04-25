package com.lailatulcoders.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lailatulcoders.model.Product;
import com.lailatulcoders.model.Supplier;
import com.lailatulcoders.service.SupplierService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/{productId}")
    public List<Supplier> getAllSuppliers(@PathVariable int productId) {
        logger.info("[REQUEST] Get suppliers for product {}", productId);
        try {

            return supplierService.getAllSuppliers(productId);

        } catch (Exception e) {
            logger.error("[ERROR GET SUPPLIERS] {}", e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping("/{productId}/best")
    public Supplier getBestSupplier(@PathVariable int productId) {
        logger.info("[REQUEST] Best supplier for product {}", productId);
        try {

            return supplierService.getBestSupplier(productId);

        } catch (Exception e) {
            logger.error("[ERROR BEST SUPPLIER CONTROLLER] {}", e.getMessage(), e);
            throw e;
        }
    }
}
