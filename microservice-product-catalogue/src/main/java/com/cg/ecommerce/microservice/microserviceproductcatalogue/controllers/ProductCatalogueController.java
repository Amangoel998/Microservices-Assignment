package com.cg.ecommerce.microservice.microserviceproductcatalogue.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cg.ecommerce.microservice.microserviceproductcatalogue.dto.ProductCatalogue;
import com.cg.ecommerce.microservice.microserviceproductcatalogue.dto.ProductPriceDTO;
import com.cg.ecommerce.microservice.microserviceproductcatalogue.dto.ProductStockDTO;
import com.cg.ecommerce.microservice.microserviceproductcatalogue.entities.ProductEntity;
import com.cg.ecommerce.microservice.microserviceproductcatalogue.exceptions.CustomException;
import com.cg.ecommerce.microservice.microserviceproductcatalogue.services.PriceClient;
import com.cg.ecommerce.microservice.microserviceproductcatalogue.services.ProductService;
import com.cg.ecommerce.microservice.microserviceproductcatalogue.services.StockClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ProductCatalogueController {

    RestTemplate template = new RestTemplate();

    @Autowired
    ProductService prodService;

    @Autowired
    StockClient stockClient;

    @Autowired
    PriceClient priceClient;

    @GetMapping(value="/products-catalogue", produces=" application/json")
    public List<ProductCatalogue> getProducts() throws CustomException {
        
        List<ProductEntity> products = prodService.getAllProducts();
        List<ProductCatalogue> responseProducts = new ArrayList<>(products.size());
        Map<Integer, Float> productsPrice = priceClient.getAllProductsPrice().stream().collect(
            Collectors.toMap(ProductPriceDTO::getProductId, ProductPriceDTO::getProductPrice)
        );
        Map<Integer, Integer> productsStock = stockClient.getAllProductsStock().stream().collect(
            Collectors.toMap(ProductStockDTO::getProductId, ProductStockDTO::getProductStock)
        );
        products.stream().forEach(e->
            responseProducts.add(
                new ProductCatalogue(
                    e.getProductId(), e.getProductName(),
                    productsPrice.get(e.getProductId()),
                    productsStock.get(e.getProductId()),
                    e.getProductCategory())
            )
        );
        return responseProducts;

    }
    @PostMapping()
    public ResponseEntity<String> postMethod(){
        return new ResponseEntity<String>("POST method not Allowed", HttpStatus.METHOD_NOT_ALLOWED);
    }
    @PutMapping()
    public ResponseEntity<String> putMethod(){
        return new ResponseEntity<String>("PUT method not Allowed", HttpStatus.METHOD_NOT_ALLOWED);
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteMethod(){
        return new ResponseEntity<String>("DELETE method not Allowed", HttpStatus.METHOD_NOT_ALLOWED);
    }


}