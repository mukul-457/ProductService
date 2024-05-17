package com.scaler.project.productservice.productservice.services;

import com.scaler.project.productservice.productservice.dtos.FakeStoreProductDto;
import com.scaler.project.productservice.productservice.models.Category;
import com.scaler.project.productservice.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpLogging;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;

@Service
public class fakeProductService implements  ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public fakeProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id , FakeStoreProductDto.class);
        if (fakeStoreProductDto == null){
            throw new FindException();
        }
        return convertDtoToProduct(fakeStoreProductDto);

    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeProducts = restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreProductDto[].class);
        if (fakeProducts == null){
            return null;
        }
        List<Product> allProducts = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: fakeProducts){
            allProducts.add(convertDtoToProduct(fakeStoreProductDto));
        }
        return allProducts;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto newFakeProduct = restTemplate.postForObject("https://fakestoreapi.com/products", convertProductToFakeStoreDto(product), FakeStoreProductDto.class);
        if (newFakeProduct == null){
            return null;
        }
        return convertDtoToProduct(newFakeProduct);
    }

    @Override
    public Product deleteProductById(Long id) {
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        Log logger = HttpLogging.forLogName(getClass());
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class,
                        restTemplate.getMessageConverters());
        FakeStoreProductDto deletedProduct=  restTemplate.execute(
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.DELETE, requestCallback, responseExtractor);
        if (deletedProduct == null) {
            return null;
        }
        return convertDtoToProduct(deletedProduct);
    }

    @Override
    public Product replaceProductById(Long id) {
        return new Product();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        FakeStoreProductDto fakeStoreProductDto = convertProductToFakeStoreDto(product);
        FakeStoreProductDto updatedProduct = restTemplate.patchForObject(
                "https://fakestoreapi.com/products/" + id ,
                fakeStoreProductDto , FakeStoreProductDto.class);
        return convertDtoToProduct(updatedProduct);
    }

    public Product convertDtoToProduct(FakeStoreProductDto dto) {
        Product product = new Product();

        product.setId(dto.getId());
        product.setTitle(dto.getTitle());

        Category category = new Category();
        category.setTitle(dto.getCategory());
        product.setCategory(category);

        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());

        return product;
    }

    public  FakeStoreProductDto convertProductToFakeStoreDto(Product product){
        FakeStoreProductDto dto = new FakeStoreProductDto();
        dto.setTitle(product.getTitle());
        dto.setDescription(product.getDescription());
        if (product.getCategory() != null){
            dto.setCategory(product.getCategory().getTitle());
        }
        dto.setPrice(product.getPrice());
        return dto;
    }

}
