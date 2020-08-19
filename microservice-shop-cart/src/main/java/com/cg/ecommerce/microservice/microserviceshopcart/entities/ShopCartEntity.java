package com.cg.ecommerce.microservice.microserviceshopcart.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="shopcart_items")
@NamedNativeQueries({
    @NamedNativeQuery(
        name = "ShopCartEntity.findAllUserItems",
        query="SELECT order_id AS orderId, user_id AS userId, product_id AS productID, quantity AS quantity FROM shopcart_items WHERE user_id=:userId"
    ),
    @NamedNativeQuery(
        name = "ShopCartEntity.deleteUserItem",
        query="DELETE FROM shopcart_items WHERE user_id=:userId AND product_id=:productId"
    )
})
public class ShopCartEntity {
    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="order_id")
    private Integer orderId;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="product_id")
    private Integer productId;

    @Column(name="quantity")
    private Integer quantity;

    public ShopCartEntity() {
    }

    public ShopCartEntity(Integer userId, Integer productId, Integer quantity) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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