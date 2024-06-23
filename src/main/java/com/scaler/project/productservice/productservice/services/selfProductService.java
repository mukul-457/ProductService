package com.scaler.project.productservice.productservice.services;

import com.scaler.project.productservice.productservice.exceptions.ProductLimitReachedException;
import com.scaler.project.productservice.productservice.models.Category;
import com.scaler.project.productservice.productservice.models.Product;
import com.scaler.project.productservice.productservice.repos.CategoryRepo;
import com.scaler.project.productservice.productservice.repos.ProductRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class selfProductService implements ProductService{

    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;

    public  selfProductService(ProductRepo productRepo, CategoryRepo categoryRepo){
        this.categoryRepo = categoryRepo;
        this.productRepo = productRepo;
    }
    @Override
    public Product getProductById(Long id) throws ProductLimitReachedException {
        Optional<Product> product  = productRepo.findById(id);
        if (product.isEmpty()){
            //throw new NoSuchElementException("Product not found");
            throw new EntityNotFoundException("Product with given id Not found");
        }
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        // BELOW BLOCK NOT NEEDED IF WE SELECT CASCADE TYPE AS PERSIST FOR CATEGORY COL OF PRODUCT ENTITY
//        if (product.getCategory() == null ){
//            Category unknown_category = new Category();
//            unknown_category.setTitle("Unknown");
//            Category savedCategory  =  categoryRepo.save(unknown_category);
//            product.setCategory(savedCategory);
//        }else{
//            Category category = new Category();
//            category.setTitle(product.getCategory().getTitle());
//            Category savedCategory =  categoryRepo.save(category);
//            product.setCategory(savedCategory);
//        }
        return productRepo.save(product);
    }

    @Override
    public Product deleteProductById(Long id) {
        return null;
    }

    @Override
    public Product replaceProductById(Long id) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }
}
