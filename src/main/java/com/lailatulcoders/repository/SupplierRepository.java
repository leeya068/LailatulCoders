package com.lailatulcoders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lailatulcoders.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    
}
