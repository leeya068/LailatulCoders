package com.lailatulcoders.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lailatulcoders.model.Product;
import com.lailatulcoders.model.Supplier;
import com.lailatulcoders.service.SupplierService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    public String addSupplier(@RequestBody Product product,
                             @RequestParam String name,
                             @RequestParam double price,
                             @RequestParam int leadTime) {
    
        Supplier supplier = new Supplier();
        supplier.setName(name);
        supplier.setPrice(price);
        supplier.setLeadTime(leadTime);
    
        supplierService.addSupplier(product, supplier);
    
        return "Supplier added for product " + product.getId();
    }

    @GetMapping("/{productId}")
    public List<Supplier> getAllSuppliers(@RequestBody Product product) {
        return supplierService.getAllSuppliers(product);
    }

    @GetMapping("/{productId}/best")
    public Supplier getBestSupplier(@RequestBody Product product) {
        return supplierService.getBestSupplier(product);
    }
    
    
    
}
