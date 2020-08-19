package com.cg.ecommerce.microservice.microserviceshopcart.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.ecommerce.microservice.microserviceshopcart.dao.ShopCartDao;
import com.cg.ecommerce.microservice.microserviceshopcart.dto.CartItemsResponse;
import com.cg.ecommerce.microservice.microserviceshopcart.dto.ItemDetail;
import com.cg.ecommerce.microservice.microserviceshopcart.dto.ShopItem;
import com.cg.ecommerce.microservice.microserviceshopcart.entities.ShopCartEntity;
import com.cg.ecommerce.microservice.microserviceshopcart.exceptions.CustomException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    private ShopCartDao shopCartDao;

    @Override
    public List<CartItemsResponse> getAllProductsStock() throws CustomException {
        List<ShopCartEntity> items = null;
        try{
            items = shopCartDao.findAll();
            if(items==null || items.size()<1)
                throw new CustomException("No Item in user's cart");
        }catch(Exception e){
            throw new CustomException(e.getMessage(), e);
        }
        Map<Integer, CartItemsResponse> userItems = new HashMap<>();
        items.stream().forEach(e->{
            CartItemsResponse item = userItems.get(e.getUserId());
            if(item==null)
                item = new CartItemsResponse(e.getUserId(), new ArrayList<>());
            item.addItem(new ItemDetail(e.getOrderId(), e.getProductId(), e.getQuantity()));
            userItems.put(e.getUserId(), item);
        });
        return List.copyOf(userItems.values());
    }

    @Override
    public ShopCartEntity addItemInCart(int userId, int productId, int quantity) throws CustomException {
        ShopCartEntity item = new ShopCartEntity(userId, productId, quantity);
        try{
            shopCartDao.save(item);
            return item;
        }catch(Exception e){
            throw new CustomException(e.getMessage(), e);
        }   
    }

    @Override
    public CartItemsResponse getItemsOfUser(int userId) throws CustomException {
        List<ShopItem> items = null;
        try{
            items = shopCartDao.findAllUserItems(userId);
            if(items==null || items.size()<1)
                throw new CustomException("No Item in user's cart");
        }catch(Exception e){
            throw new CustomException(e.getMessage(), e);
        }
        CartItemsResponse userItems = new CartItemsResponse(userId, new ArrayList<>());
        items.stream().forEach(e->
            userItems.addItem(new ItemDetail(e.getOrderId(), e.getProductId(), e.getQuantity()))
        );
        return userItems;
    }

    @Override
    public void deleteItemFromCart(int orderId) throws CustomException {
        try{
            shopCartDao.deleteById(orderId);
        }catch(Exception e){
            throw new CustomException(e.getMessage(), e);
        }
    }
    
}