package com.cg.ecommerce.microservice.microserviceshopcart.dto;

import java.util.List;

public class CartItemsResponse {
    private int userId;
    private List<ItemDetail> items;

    public CartItemsResponse() {
    }
    
    public CartItemsResponse(int userId, List<ItemDetail> items) {
        this.userId = userId;
        this.items = items;
    }

    public void addItem(ItemDetail newItem){
        items.add(newItem);
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<ItemDetail> getItems() {
        return items;
    }

    public void setItems(List<ItemDetail> items) {
        this.items = items;
    }
}