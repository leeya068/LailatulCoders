package com.lailatulcoders.service;

import java.util.List;

import com.lailatulcoders.model.Product;
import com.lailatulcoders.model.Supplier;

public interface SupplierService {
    public void addSupplier(Product product, Supplier supplier);
    List<Supplier> getAllSuppliers(Product product);
    Supplier getBestSupplier(Product product); // for now just check by the cheapest and leadTime(shipping speed), just make a shitty weightage formula. Later will implement based on live traffic news
}