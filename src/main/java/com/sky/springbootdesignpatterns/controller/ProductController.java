package com.sky.springbootdesignpatterns.controller;

import com.sky.springbootdesignpatterns.dto.ProductRequest;
import com.sky.springbootdesignpatterns.service.ProductService;
import com.sky.springbootdesignpatterns.service.ProductStrategyEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public Object saveProduct(@RequestBody ProductRequest request){
        return productService.saveProduct(request);
    }

    @GetMapping("/list")
    public Map<String, Object> getProducts(){
        return productService.getPoducts(ProductStrategyEnum.LISTING);
    }

    @GetMapping("/filters")
    public Map<String, Object> getProductsFilter(){
        return productService.getPoducts(ProductStrategyEnum.FILTERS);
    }
}
