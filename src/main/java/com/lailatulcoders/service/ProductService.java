package com.lailatulcoders.service;

import java.util.List;

import com.lailatulcoders.model.Product;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(int id);
    Product updateProduct(int id, Product product);
    void deleteProduct(int id);
}
