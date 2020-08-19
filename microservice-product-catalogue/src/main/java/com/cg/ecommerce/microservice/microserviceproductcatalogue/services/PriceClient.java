package com.cg.ecommerce.microservice.microserviceproductcatalogue.services;

import java.util.List;

import com.cg.ecommerce.microservice.microserviceproductcatalogue.dto.ProductPriceDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="product-price-service")
public interface PriceClient {
    @GetMapping(value="/api/price/{product_id}")
    ProductPriceDTO getProductPrice(@PathVariable Integer product_id);
    @GetMapping(value="/api/price")
    List<ProductPriceDTO> getAllProductsPrice();

}