package com.sky.springbootdesignpatterns.service.impl;

import com.sky.springbootdesignpatterns.dto.ProductResponse;
import com.sky.springbootdesignpatterns.entity.Product;
import com.sky.springbootdesignpatterns.service.ProductStrategyEnum;
import com.sky.springbootdesignpatterns.service.ProductStrategyService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@NoArgsConstructor
public class ProductFiltersService implements ProductStrategyService {

    @Override
    public boolean isStrategyType(ProductStrategyEnum strategyType) {
        return strategyType == ProductStrategyEnum.FILTERS;
    }

    @Override
    public ProductResponse constructProductResponse(List<Product> products) {
        Map<String,List<Product>> res =
                products.stream().collect(Collectors.groupingBy(Product::getName));
        ProductResponse productResponse = new ProductResponse();
        productResponse.setFilters(res);
        return productResponse;
    }

    @Override
    public Map<String, Object> sortproductResponse(ProductResponse response) {
        Map<String, Object> ouptut = new HashMap<>();
        ouptut.put("data",response);
        return ouptut;
    }

}
