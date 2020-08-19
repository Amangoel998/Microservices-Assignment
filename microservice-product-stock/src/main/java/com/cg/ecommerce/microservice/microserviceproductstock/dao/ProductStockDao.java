package com.cg.ecommerce.microservice.microserviceproductstock.dao;

import com.cg.ecommerce.microservice.microserviceproductstock.entities.ProductStockEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStockDao extends JpaRepository<ProductStockEntity, Integer> {
    
}