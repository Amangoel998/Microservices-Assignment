package com.cg.ecommerce.microservice.microserviceproductcatalogue.services;

import java.util.List;

import com.cg.ecommerce.microservice.microserviceproductcatalogue.entities.ProductEntity;
import com.cg.ecommerce.microservice.microserviceproductcatalogue.exceptions.CustomException;

public interface ProductService {
    List<ProductEntity> getAllProducts() throws CustomException;
}