package com.lailatulcoders.service.impl;

import org.springframework.stereotype.Service;

import com.lailatulcoders.model.Product;
import com.lailatulcoders.model.Supplier;
import com.lailatulcoders.service.InventoryService;
import com.lailatulcoders.service.OrderService;
import com.lailatulcoders.service.ProcurementService;
import com.lailatulcoders.service.SupplierService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProcurementServiceImpl implements ProcurementService {
    private final InventoryService inventoryService;
    private final SupplierService supplierService;
    private final OrderService orderService;

    @Override
    public void processRestock(Product product) {

        if(!inventoryService.needsRestock(product)) {
            System.out.println("No restock needed.");
            return;
        }

        System.out.println("Restock Triggered!");

        Supplier best = supplierService.getBestSupplier(product);
        int quantity = 50; // gotta replace with AI-driven decision.

        orderService.createOrder(product, best, quantity);
        inventoryService.addStock(product, quantity);
    }
}
