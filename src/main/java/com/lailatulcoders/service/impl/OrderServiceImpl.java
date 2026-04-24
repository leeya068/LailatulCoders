package com.lailatulcoders.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.lailatulcoders.model.Order;
import com.lailatulcoders.model.Product;
import com.lailatulcoders.model.Supplier;
import com.lailatulcoders.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final Map<Integer, Order> orderDB = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger();

    @Override
    public Order createOrder(Product product, Supplier supplier, int quantity) {

        Order order = new Order();
        order.setId(idCounter.incrementAndGet());
        order.setProductId(product.getId());
        order.setSupplierId(supplier.getId());
        order.setQuantity(quantity);
        order.setStatus("CREATED");

        orderDB.put(order.getId(), order);

        System.out.println("[ORDER CREATED] ID: " + order.getId()
                    + " Product: " + product.getId()
                    + " Supplier: " + supplier.getId()
                    + " Qty: " + quantity);

        return order;
    }
}
