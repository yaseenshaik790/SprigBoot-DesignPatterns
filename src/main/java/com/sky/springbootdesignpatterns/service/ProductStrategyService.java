package com.sky.springbootdesignpatterns.service;

import com.sky.springbootdesignpatterns.dto.ProductResponse;
import com.sky.springbootdesignpatterns.entity.Product;

import java.util.*;
import java.util.stream.Collectors;

public interface ProductStrategyService {

    boolean isStrategyType(ProductStrategyEnum strategyType);

    ProductResponse constructProductResponse(List<Product> products);

    Map<String,Object> sortproductResponse(ProductResponse response);

    default List<Product> sortByProductName(Collection<Product> list){
        List<Product> flatList = list.stream()
                .sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
        return flatList;
    }
}
