package com.scaler.project.productservice.productservice.controllers;

import com.scaler.project.productservice.productservice.ProductServiceApplication;
import com.scaler.project.productservice.productservice.models.Product;
import com.scaler.project.productservice.productservice.services.ProductService;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products/")
public class productController {

    private ProductService productService;

    public productController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<>(productService.getProductById(id), HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (RuntimeException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){

        return productService.createProduct(product);
    }

    @PutMapping("/replcae/{id}")
    public Product replaceProductById(@PathVariable("id") Long id , @RequestBody Product product){
        return new Product();
    }

    @PatchMapping("{id}")
    public Product updateProductById(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.updateProduct(id , product);
    }

    @DeleteMapping("{id}")
    public  Product deleteProductById(@PathVariable("id") Long id){
        return productService.deleteProductById(id);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(){
        System.out.println("something went wrong");
        return new ResponseEntity<>("Some thing went wrong ", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

