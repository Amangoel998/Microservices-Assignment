package com.cg.ecommerce.microservice.microserviceproductcatalogue.exceptions;

public class CustomException extends Exception{
    private static final long serialVersionUID = -3748949776799832337L;

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
    
}