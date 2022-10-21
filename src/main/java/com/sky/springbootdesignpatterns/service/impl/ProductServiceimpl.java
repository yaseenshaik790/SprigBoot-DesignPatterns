package com.sky.springbootdesignpatterns.service.impl;

import com.sky.springbootdesignpatterns.dto.ProductRequest;
import com.sky.springbootdesignpatterns.dto.ProductResponse;
import com.sky.springbootdesignpatterns.entity.Product;
import com.sky.springbootdesignpatterns.repository.ProductRepository;
import com.sky.springbootdesignpatterns.service.ProductService;
import com.sky.springbootdesignpatterns.service.ProductStrategyEnum;
import com.sky.springbootdesignpatterns.service.ProductStrategyFactory;
import com.sky.springbootdesignpatterns.service.ProductStrategyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceimpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductStrategyFactory strategyFactory;

    @Override
    public Object saveProduct(ProductRequest request) {
        Product product = new Product();
        BeanUtils.copyProperties(request,product);
        return repository.save(product);
    }

    @Override
    public Map<String, Object> getPoducts(ProductStrategyEnum productStrategyEnum) {
        List<Product> products = repository.findAll();
        ProductStrategyService strategyService = strategyFactory.getStrategyServiceMap()
                .get(productStrategyEnum);
        ProductResponse response = strategyService.constructProductResponse(products);
        Map<String, Object> objectMap = strategyService.sortproductResponse(response);
        return objectMap;
    }
}
