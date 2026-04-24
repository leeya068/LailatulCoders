package com.lailatulcoders.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lailatulcoders.model.Product;
import com.lailatulcoders.service.ProcurementService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/procurement")
@RequiredArgsConstructor
public class ProcurementController {
    
    private final ProcurementService procurementService;

    @PostMapping("/restock/{productId}")
    public String restock(@PathVariable Product product) {

        procurementService.processRestock(product);
        return "Restock process triggered for product " + product.getName() + " [" + product.getId() + "].";
    }
    
}
