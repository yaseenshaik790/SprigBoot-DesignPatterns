package com.sky.springbootdesignpatterns.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductStrategyFactory {

    private Map<ProductStrategyEnum,ProductStrategyService> strategyServiceMap = new EnumMap(ProductStrategyEnum.class);

    @Autowired
    private List<ProductStrategyService> productStrategyServices;

    @PostConstruct
    public void productStrategyMap() {
        Arrays.stream(ProductStrategyEnum.values()).forEach(prodStrategyEnum -> {
            productStrategyServices.stream().forEach(prodStrategyService -> {
                if (prodStrategyService.isStrategyType(prodStrategyEnum)) {
                    strategyServiceMap.put(prodStrategyEnum,prodStrategyService);
                }
            });
        });
    }

    public Map<ProductStrategyEnum, ProductStrategyService> getStrategyServiceMap() {
        return strategyServiceMap;
    }
}
