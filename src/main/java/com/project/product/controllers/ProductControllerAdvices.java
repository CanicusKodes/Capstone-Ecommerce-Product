package com.project.product.controllers;

import com.project.product.dtos.ExceptionDto;
import com.project.product.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductControllerAdvices {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody()
    public ExceptionDto handleProductNotFoundExcpetion(ProductNotFoundException e) {
        return new ExceptionDto(HttpStatus.NOT_FOUND, e.getMessage());
    }
}
