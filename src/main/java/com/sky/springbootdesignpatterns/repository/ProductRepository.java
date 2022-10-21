package com.sky.springbootdesignpatterns.repository;

import com.sky.springbootdesignpatterns.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
