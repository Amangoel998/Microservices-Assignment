package com.cg.ecommerce.microservice.microserviceproductcatalogue.services;

import java.util.List;

import com.cg.ecommerce.microservice.microserviceproductcatalogue.dao.ProductDao;
import com.cg.ecommerce.microservice.microserviceproductcatalogue.entities.ProductEntity;
import com.cg.ecommerce.microservice.microserviceproductcatalogue.exceptions.CustomException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao prodDao;
    @Override
    public List<ProductEntity> getAllProducts() throws CustomException {
        try{
            return prodDao.findAll();
        }catch(Exception e){
            throw new CustomException(e.getMessage(), e);
        }
    }
    
}