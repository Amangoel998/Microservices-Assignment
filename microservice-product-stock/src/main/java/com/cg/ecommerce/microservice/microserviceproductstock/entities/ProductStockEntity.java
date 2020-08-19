package com.cg.ecommerce.microservice.microserviceproductstock.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products_stock")
public class ProductStockEntity {
    @Id
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_stock")
    private Integer productStock;

    public ProductStockEntity() {
    }

    public ProductStockEntity(Integer productId, Integer productStock) {
        this.productId = productId;
        this.productStock = productStock;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }
}