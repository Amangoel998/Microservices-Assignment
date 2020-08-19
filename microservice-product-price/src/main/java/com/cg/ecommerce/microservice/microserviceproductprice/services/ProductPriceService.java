package com.cg.ecommerce.microservice.microserviceproductprice.services;

import java.util.List;

import com.cg.ecommerce.microservice.microserviceproductprice.exceptions.CustomException;

import com.cg.ecommerce.microservice.microserviceproductprice.entities.ProductPriceEntity;

public interface ProductPriceService{
    List<ProductPriceEntity> getAllProductsPrice() throws CustomException;
    ProductPriceEntity getProductPrice(int productId) throws CustomException;
}