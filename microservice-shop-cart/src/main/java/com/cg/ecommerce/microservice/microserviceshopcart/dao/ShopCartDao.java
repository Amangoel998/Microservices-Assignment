package com.cg.ecommerce.microservice.microserviceshopcart.dao;

import java.util.List;

import com.cg.ecommerce.microservice.microserviceshopcart.dto.ShopItem;
import com.cg.ecommerce.microservice.microserviceshopcart.entities.ShopCartEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface ShopCartDao extends JpaRepository<ShopCartEntity,Integer> {
    List<ShopItem> findAllUserItems(int userId);
    @Modifying
    void deleteUserItem(int userId, int productId);
}