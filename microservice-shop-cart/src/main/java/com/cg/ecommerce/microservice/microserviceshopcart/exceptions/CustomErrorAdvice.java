package com.cg.ecommerce.microservice.microserviceshopcart.exceptions;

import java.sql.SQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import feign.RetryableException;

@ControllerAdvice
public class CustomErrorAdvice {
    @ExceptionHandler({ CustomException.class, SQLException.class, NullPointerException.class })
    public ResponseEntity<ErrorInfo> handle1(Exception ce) {
        ErrorInfo error = new ErrorInfo(ce.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler({ RetryableException.class })
    public ResponseEntity<ErrorInfo> handleServiceClientError(Exception ce) {
        ErrorInfo error = new ErrorInfo(ce.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}