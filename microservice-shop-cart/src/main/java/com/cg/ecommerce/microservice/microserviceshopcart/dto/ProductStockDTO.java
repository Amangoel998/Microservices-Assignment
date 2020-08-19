package com.cg.ecommerce.microservice.microserviceshopcart.dto;

public class ProductStockDTO {
    private Integer productId;

    private Integer productStock;

    public ProductStockDTO() {
    }

    public ProductStockDTO(Integer productId, Integer productStock) {
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