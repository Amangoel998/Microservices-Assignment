package com.cg.ecommerce.microservice.microserviceproductprice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ecommerce.microservice.microserviceproductprice.entities.ProductPriceEntity;

public interface ProductPriceDao extends JpaRepository<ProductPriceEntity, Integer> {
    
}