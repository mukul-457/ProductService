package com.scaler.project.productservice.productservice.advices;

import com.scaler.project.productservice.productservice.dtos.ExceptionDto;
import com.scaler.project.productservice.productservice.exceptions.ProductLimitReachedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductsExceptionHandler {

    @ExceptionHandler(ProductLimitReachedException.class)
    public ResponseEntity<ExceptionDto> productLimitHandler(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("This store has only 20 products");
        exceptionDto.setStatusCode("MAX_PRODUCT_LIMIT_REACHED");
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}
