package com.sky.springbootdesignpatterns.service;

import com.sky.springbootdesignpatterns.dto.ProductRequest;

import java.util.Map;

public interface ProductService {

    Object saveProduct(ProductRequest request);

    Map<String, Object> getPoducts(ProductStrategyEnum listing);
}
