package com.cg.ecommerce.microservice.microserviceproductcatalogue.dto;

public class ProductPriceDTO {
    private Integer ProductId;
    private Float ProductPrice;

    public ProductPriceDTO() {
    }

    public ProductPriceDTO(Integer productId, Float productPrice) {
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