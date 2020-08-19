package com.cg.ecommerce.microservice.microserviceshopcart.dto;

public class AddShopItem {
    private Integer userId;
    private Integer productId;
    private Integer quantity;

    public AddShopItem() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
}