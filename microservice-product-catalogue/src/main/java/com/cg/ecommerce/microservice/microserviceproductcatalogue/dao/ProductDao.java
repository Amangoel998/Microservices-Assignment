package com.cg.ecommerce.microservice.microserviceproductcatalogue.dao;

import com.cg.ecommerce.microservice.microserviceproductcatalogue.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<ProductEntity,Integer>{
    
}