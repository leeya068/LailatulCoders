package com.lailatulcoders.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lailatulcoders.model.Product;
import com.lailatulcoders.service.InventoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/inventory")
public class InventoryController {
    
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/add")
    public String addStock(@RequestBody Product product,
                           @RequestParam int quantity) {
        inventoryService.addStock(product, quantity);
        return "Stock added successfully";
    }

    @PostMapping("/remove")
    public String removeStock(@RequestBody Product product,
                           @RequestParam int quantity) {
        inventoryService.removeStock(product, quantity);
        return "Stock removed successfully";
    }
    
    @GetMapping("/restock-check")
    public boolean needsRestock(@RequestBody Product product) {
        return inventoryService.needsRestock(product);
    }
    
    
}
