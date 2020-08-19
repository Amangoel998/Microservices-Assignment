package com.cg.ecommerce.microservice.microserviceproductprice.controllers;

import java.util.List;

import com.cg.ecommerce.microservice.microserviceproductprice.exceptions.CustomException;
import com.cg.ecommerce.microservice.microserviceproductprice.services.ProductPriceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ecommerce.microservice.microserviceproductprice.entities.ProductPriceEntity;

@RestController
@RequestMapping("/api")
public class ProductPriceController {
    @Autowired
    private ProductPriceService priceService;

    @GetMapping(value="/price", produces="application/json")
    public List<ProductPriceEntity> getProductsPrice() throws CustomException {
        // return new HashMap<Integer,Float>();
        return priceService.getAllProductsPrice();
    }
    @GetMapping(value="/price/{productId}", produces="application/json")
    public ProductPriceEntity getAllProductsPrice(@PathVariable int productId) throws CustomException {
        if(productId<=0)
            throw new CustomException("Invalid Request");
        return priceService.getProductPrice(productId);
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