package com.scaler.project.productservice.productservice.services;

import com.scaler.project.productservice.productservice.models.Product;
import com.scaler.project.productservice.productservice.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> searchProduct(String title, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepo.findAllByTitleContains(title, pageable);
    }
}
