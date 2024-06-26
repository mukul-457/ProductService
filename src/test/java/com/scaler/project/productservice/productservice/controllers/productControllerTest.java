package com.scaler.project.productservice.productservice.controllers;

import com.scaler.project.productservice.productservice.exceptions.ProductLimitReachedException;
import com.scaler.project.productservice.productservice.exceptions.ProductNotFoundException;
import com.scaler.project.productservice.productservice.models.Product;
import com.scaler.project.productservice.productservice.repos.ProductRepo;
import com.scaler.project.productservice.productservice.services.selfProductService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ProductControllerTest {

    @Autowired
    ProductRepo productRepo;

    @MockBean
    selfProductService productService;

    @Autowired
    productController productController;
    @Test
    void Test_whenValidIdIsPassed_thenReturnValidProduct() throws ProductLimitReachedException, ProductNotFoundException {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("Product 1");
        product.setPrice(100.0);
        product.setQuantity(10);
        product.setCategory(null);
        when(productService.getProductById(1L)).thenReturn(product);
        ResponseEntity<Product> response = productController.getProductById(1L);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(product.getId(), response.getBody().getId());
        assertEquals(product, productController.getProductById(1L).getBody());

    }

    @Test
    void Test_whenInvalidIdIsPassed_thenThrowException() throws ProductLimitReachedException, ProductNotFoundException{
        when(productService.getProductById(21L)).thenThrow(new ProductLimitReachedException("This store does not have more than 20 products"));
        assertThrows(ProductLimitReachedException.class, () -> productController.getProductById(21L));
    }

    @Test
    void Test_whenNotExistingIdIsPassed_thenThrowException() throws ProductNotFoundException, ProductLimitReachedException{
        when(productService.getProductById(2L)).thenThrow(new EntityNotFoundException("Product with given id Not found"));
        assertThrows(EntityNotFoundException.class, () -> productController.getProductById(2L));
    }

    @Test
    //this test fails to execute because of issue with mocking prodcutRepo
    // I wanted to call DB at the time of testing, but it is not working
    void Test_whenGetProductByIdIsCalled_thenCallRealProductService() throws ProductLimitReachedException, ProductNotFoundException{
        when(productService.getProductById(1L)).thenCallRealMethod();
        ResponseEntity<Product>  response = productController.getProductById(1L);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println(response.getBody().getTitle());
        assertEquals(1L, response.getBody().getId());
    }
}