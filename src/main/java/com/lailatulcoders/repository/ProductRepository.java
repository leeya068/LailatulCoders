package com.lailatulcoders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lailatulcoders.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
