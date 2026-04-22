package com.lailatulcoders.Services;

import java.util.List;

import com.lailatulcoders.DTO.Supplier;

public interface SupplierService {
    List<Supplier> getAllSuppliers(int productId);
    Supplier getBestSupplier(int productId); // for now just check by the cheapest and leadTime(shipping speed), just make a shitty weightage formula. Later will implement based on live traffic news
}