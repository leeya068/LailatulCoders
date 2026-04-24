package com.lailatulcoders.service;

import com.lailatulcoders.model.Order;
import com.lailatulcoders.model.Product;
import com.lailatulcoders.model.Supplier;

public interface OrderService {
    Order createOrder(Product product, Supplier supplier, int quantity);
}
