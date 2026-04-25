package com.lailatulcoders.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lailatulcoders.model.Product;
import com.lailatulcoders.repository.ProductRepository;
import com.lailatulcoders.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        return productRepository.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setStockLevel(updatedProduct.getStockLevel());
            product.setRestockThreshold(updatedProduct.getRestockThreshold());
            return productRepository.save(product);
        }).orElse(null);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
