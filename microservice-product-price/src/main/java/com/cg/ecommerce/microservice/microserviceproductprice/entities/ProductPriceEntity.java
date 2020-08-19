package com.cg.ecommerce.microservice.microserviceproductprice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products_price")
public class ProductPriceEntity {
    @Id
    @Column(name="product_id")
    private Integer ProductId;

    @Column(name="product_price")
    private Float ProductPrice;

    public ProductPriceEntity() {
    }

    public ProductPriceEntity(Integer productId, Float productPrice) {
        ProductId = productId;
        ProductPrice = productPrice;
    }

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer productId) {
        ProductId = productId;
    }

    public Float getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(Float productPrice) {
        ProductPrice = productPrice;
    }
    
}