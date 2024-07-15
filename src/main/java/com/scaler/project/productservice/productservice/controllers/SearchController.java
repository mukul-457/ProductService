package com.scaler.project.productservice.productservice.controllers;

import com.scaler.project.productservice.productservice.dtos.SearchProductDto;
import com.scaler.project.productservice.productservice.models.Product;
import com.scaler.project.productservice.productservice.services.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    public List<Product> searchProduct(@RequestBody SearchProductDto searchProductDto) {
        return searchService.searchProduct(searchProductDto.getTitle(), searchProductDto.getPage(), searchProductDto.getSize());
    }

    @GetMapping
    public List<Product> searchProductByTitle(@RequestParam String title, @RequestParam int page, @RequestParam int size) {
        return searchService.searchProduct(title, page, size);
    }
}
