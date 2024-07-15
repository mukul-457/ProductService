package com.scaler.project.productservice.productservice.services;

import com.scaler.project.productservice.productservice.models.Product;
import com.scaler.project.productservice.productservice.repos.ProductRepo;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {


    private final ProductRepo productRepo;

    public SearchService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> searchProduct(String title, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "category.title").and(Sort.by(Sort.Direction.DESC, "title")));
        return productRepo.findAllByTitleContains(title, pageable);
    }
}
