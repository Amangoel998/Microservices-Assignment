package com.cg.ecommerce.microservice.microserviceshopcart.services;

import java.util.List;

import com.cg.ecommerce.microservice.microserviceshopcart.dto.CartItemsResponse;
import com.cg.ecommerce.microservice.microserviceshopcart.entities.ShopCartEntity;
import com.cg.ecommerce.microservice.microserviceshopcart.exceptions.CustomException;

public interface ShopCartService {
    CartItemsResponse getItemsOfUser(int userId) throws CustomException;
    List<CartItemsResponse> getAllProductsStock() throws CustomException;
    ShopCartEntity addItemInCart(int userId, int productId, int quantity) throws CustomException;
    void deleteItemFromCart(int orderId) throws CustomException;
}