package com.scaler.project.productservice.productservice.repos;

import com.scaler.project.productservice.productservice.models.Product;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {

    @NonNull
    Optional<Product> findById(@NonNull Long id);

    void deleteProductById(Long Id);

    @NonNull
    <S extends Product> S save ( @NonNull S  product);

}
