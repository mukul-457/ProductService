package com.scaler.project.productservice.productservice.services;

import com.scaler.project.productservice.productservice.models.Product;

import javax.xml.stream.events.ProcessingInstruction;
import java.util.List;

public interface ProductService {

    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product deleteProductById(Long id);

    Product replaceProductById(Long id);

    Product updateProduct(Long id, Product product);

}
