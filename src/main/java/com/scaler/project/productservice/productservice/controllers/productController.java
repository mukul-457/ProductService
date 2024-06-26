package com.scaler.project.productservice.productservice.controllers;
import com.scaler.project.productservice.productservice.exceptions.ProductLimitReachedException;
import com.scaler.project.productservice.productservice.exceptions.ProductNotFoundException;
import com.scaler.project.productservice.productservice.models.Product;
import com.scaler.project.productservice.productservice.services.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.PrinterAbortException;
import java.lang.module.FindException;
import java.util.List;

@RestController
@RequestMapping("/products/")
public class productController {

    private ProductService productService;

    public productController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductLimitReachedException , ProductNotFoundException {
            return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
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

    @ExceptionHandler(FindException.class)
    public ResponseEntity<String> handleException(){
        System.out.println("ERROR: Product Not Found");
        return new ResponseEntity<>("Product you are looking for does not exist", HttpStatus.NOT_FOUND);
    }
}

