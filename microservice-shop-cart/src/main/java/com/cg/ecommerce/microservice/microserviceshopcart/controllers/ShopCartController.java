package com.cg.ecommerce.microservice.microserviceshopcart.controllers;

import java.util.List;

import com.cg.ecommerce.microservice.microserviceshopcart.dto.AddShopItem;
import com.cg.ecommerce.microservice.microserviceshopcart.dto.CartItemsResponse;
import com.cg.ecommerce.microservice.microserviceshopcart.dto.ProductStockDTO;
import com.cg.ecommerce.microservice.microserviceshopcart.entities.ShopCartEntity;
import com.cg.ecommerce.microservice.microserviceshopcart.exceptions.CustomException;
import com.cg.ecommerce.microservice.microserviceshopcart.services.ShopCartService;
import com.cg.ecommerce.microservice.microserviceshopcart.services.StockClientService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

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

@RestController
@RequestMapping("/api")
@DefaultProperties(defaultFallback="classDefaultFallback", groupKey = "DefaultGroupKey", ignoreExceptions = {CustomException.class})
public class ShopCartController {

    @Autowired
    private ShopCartService shopCartService;

    @Autowired
    private StockClientService stockFeignClient;

    List<Object> classDefaultFallback() throws CustomException{
        throw new CustomException("Error while retrieving Object");
    }
    @HystrixCommand
    @GetMapping(value = "/shopcart", produces = "application/json")
    public List<CartItemsResponse> getProductsStock() throws CustomException {
        return shopCartService.getAllProductsStock();
    }

    @HystrixCommand
    @GetMapping(value = "/items/{userId}", produces = "application/json")
    public CartItemsResponse getProductStock(@PathVariable Integer userId) throws CustomException {
        return shopCartService.getItemsOfUser(userId);
    }

    @HystrixCommand
    @PostMapping(value="/items/add", produces="application/json", consumes="application/json")
    public ResponseEntity<ShopCartEntity> postMethod(@RequestBody AddShopItem item) throws CustomException {
        ProductStockDTO productStock = stockFeignClient.getProductQuantity(item.getProductId());
        if(productStock.getProductStock()<item.getQuantity())
            throw new CustomException("The product quantity cannot be more than available stock");
        ShopCartEntity result = shopCartService.addItemInCart(item.getUserId(), item.getProductId(), item.getQuantity());
        int newQuantity = productStock.getProductStock()-item.getQuantity();
        stockFeignClient.putProductQuantity(new ProductStockDTO(item.getProductId(), newQuantity));
        return new ResponseEntity<ShopCartEntity>(result, HttpStatus.CREATED);
    }
    @HystrixCommand
    @DeleteMapping(value="/items/delete/{orderId}")
    public ResponseEntity<String> deleteMethod(@PathVariable Integer orderId) throws CustomException {
        shopCartService.deleteItemFromCart(orderId);
        return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
    }
    @PutMapping()
    public ResponseEntity<String> putMethod(){
        return new ResponseEntity<String>("PUT method not Allowed", HttpStatus.METHOD_NOT_ALLOWED);
    }
}