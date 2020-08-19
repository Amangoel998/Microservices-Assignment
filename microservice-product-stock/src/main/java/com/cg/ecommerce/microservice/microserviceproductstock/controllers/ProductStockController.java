package com.cg.ecommerce.microservice.microserviceproductstock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.cg.ecommerce.microservice.microserviceproductstock.entities.ProductStockEntity;
import com.cg.ecommerce.microservice.microserviceproductstock.exceptions.CustomException;
import com.cg.ecommerce.microservice.microserviceproductstock.services.ProductStockService;

@RestController
@RequestMapping("/api")
public class ProductStockController {
    
    @Autowired
    private ProductStockService stockService;

    @GetMapping(value="/stock", produces="application/json")
    public List<ProductStockEntity> getProductsStock() throws CustomException{
        return stockService.getAllProductsStock();
    }
    @GetMapping(value="/stock/{productId}", produces="application/json")
    public ProductStockEntity getAProductStock(@PathVariable Integer productId) throws CustomException{
        return stockService.getProductStock(productId);
    }
    @PostMapping()
    public ResponseEntity<String> postMethod(){
        return new ResponseEntity<String>("POST method not Allowed", HttpStatus.METHOD_NOT_ALLOWED);
    }
    @PutMapping(value="/stock/update", produces="application/json")
    public ProductStockEntity putMethod(@RequestBody ProductStockEntity productQuantity)
            throws CustomException {
        if(productQuantity!=null && productQuantity.getProductId()!=null)
            return stockService.updateProductStock(productQuantity);
        else
            throw new CustomException("Product Ids Doesn't match");
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteMethod(){
        return new ResponseEntity<String>("DELETE method not Allowed", HttpStatus.METHOD_NOT_ALLOWED);
    }
}