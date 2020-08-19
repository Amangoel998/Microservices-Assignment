package com.cg.ecommerce.microservice.microserviceshopcart.services;

import com.cg.ecommerce.microservice.microserviceshopcart.dto.ProductStockDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(name = "product-stock-service")
public interface StockClientService {
    @GetMapping(value="/api/stock/{product_id}")
    ProductStockDTO getProductQuantity(@PathVariable Integer product_id);

    @PutMapping(value="api/stock/update")
    ProductStockDTO putProductQuantity(@RequestBody ProductStockDTO productQuantity);
}