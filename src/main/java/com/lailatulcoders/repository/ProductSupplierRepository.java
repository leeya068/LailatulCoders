package com.lailatulcoders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lailatulcoders.model.ProductSupplier;

public interface ProductSupplierRepository extends JpaRepository<ProductSupplier, Integer> {
    List<ProductSupplier> findByProduct_Id(int productId);
}
