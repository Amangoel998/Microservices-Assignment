package com.cg.ecommerce.microservice.microserviceproductstock.services;

import java.util.List;

import com.cg.ecommerce.microservice.microserviceproductstock.exceptions.CustomException;
import com.cg.ecommerce.microservice.microserviceproductstock.entities.ProductStockEntity;

public interface ProductStockService {
    List<ProductStockEntity> getAllProductsStock() throws CustomException;
    ProductStockEntity getProductStock(int productId) throws CustomException;
    ProductStockEntity updateProductStock(ProductStockEntity updateProductStock) throws CustomException;
}