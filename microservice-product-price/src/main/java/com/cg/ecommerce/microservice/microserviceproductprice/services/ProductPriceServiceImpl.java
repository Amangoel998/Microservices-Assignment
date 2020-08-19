package com.cg.ecommerce.microservice.microserviceproductprice.services;

import java.util.List;

import com.cg.ecommerce.microservice.microserviceproductprice.exceptions.CustomException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ecommerce.microservice.microserviceproductprice.dao.ProductPriceDao;
import com.cg.ecommerce.microservice.microserviceproductprice.entities.ProductPriceEntity;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {

    @Autowired
    private ProductPriceDao priceDao;

    @Override
    public List<ProductPriceEntity> getAllProductsPrice() throws CustomException {
        try{
            List<ProductPriceEntity> prices = priceDao.findAll();
            return prices;
        }catch(Exception e){
            throw new CustomException(e.getMessage(), e);
        }
    }

    @Override
    public ProductPriceEntity getProductPrice(int productId) throws CustomException {
        try{
            return priceDao.findById(productId).get();
        }catch(Exception e){
            throw new CustomException(e.getMessage(), e);
        }
    }
    
}