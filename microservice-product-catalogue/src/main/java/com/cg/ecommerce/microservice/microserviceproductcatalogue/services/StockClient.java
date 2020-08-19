package com.cg.ecommerce.microservice.microserviceproductcatalogue.services;

import java.util.List;

import com.cg.ecommerce.microservice.microserviceproductcatalogue.dto.ProductStockDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="product-stock-service")
public interface StockClient {
    @GetMapping(value="/api/stock/{product_id}")
    ProductStockDTO getProductStock(@PathVariable Integer product_id);
    @GetMapping(value="/api/stock")
    List<ProductStockDTO> getAllProductsStock();
    
}