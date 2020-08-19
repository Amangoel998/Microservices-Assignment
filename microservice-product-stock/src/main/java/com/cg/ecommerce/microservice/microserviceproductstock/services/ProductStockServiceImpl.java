package com.cg.ecommerce.microservice.microserviceproductstock.services;

import java.util.List;

import com.cg.ecommerce.microservice.microserviceproductstock.dao.ProductStockDao;
import com.cg.ecommerce.microservice.microserviceproductstock.entities.ProductStockEntity;
import com.cg.ecommerce.microservice.microserviceproductstock.exceptions.CustomException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductStockServiceImpl implements ProductStockService {

    @Autowired
    private ProductStockDao stockDao;

    @Override
    public List<ProductStockEntity> getAllProductsStock() throws CustomException {
        try{
            List<ProductStockEntity> stonks = stockDao.findAll();
            return stonks;
        }catch(Exception e){
            throw new CustomException(e.getMessage(), e);
        }
    }

    @Override
    public ProductStockEntity getProductStock(int productId) throws CustomException {
        try{
            return stockDao.findById(productId).get();
        }catch(Exception e){
            throw new CustomException(e.getMessage(), e);
        }
    }

    @Override
    public ProductStockEntity updateProductStock(ProductStockEntity updateProductStock)
            throws CustomException {
        try{
            if(updateProductStock.getProductId() == null || !stockDao.existsById(updateProductStock.getProductId()))
                throw new CustomException("The Product Doesn't Exists");
            return stockDao.save(updateProductStock);
        }catch(Exception e){
            throw new CustomException(e.getMessage(), e);
        }
        
    }
    
}