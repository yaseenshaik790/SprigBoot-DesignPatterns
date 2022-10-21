package com.sky.springbootdesignpatterns.service.impl;

import com.sky.springbootdesignpatterns.dto.ProductResponse;
import com.sky.springbootdesignpatterns.entity.Product;
import com.sky.springbootdesignpatterns.service.ProductStrategyEnum;
import com.sky.springbootdesignpatterns.service.ProductStrategyService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
public class ProductListingService implements ProductStrategyService {

    @Override
    public boolean isStrategyType(ProductStrategyEnum strategyType) {
        return strategyType == ProductStrategyEnum.LISTING;
    }

    @Override
    public ProductResponse constructProductResponse(List<Product> products) {
        ProductResponse  productResponse = new ProductResponse();
        productResponse.setProducts(products);
        return productResponse;
    }

    @Override
    public Map<String, Object> sortproductResponse(ProductResponse response) {
        if (!CollectionUtils.isEmpty(response.getProducts())){
            response.getProducts().sort((p1,p2)-> p2.getName().compareTo(p1.getName()));
        }
        Map<String, Object> ouptut = new HashMap<>();
        ouptut.put("data",response);
        return ouptut;
    }
}
