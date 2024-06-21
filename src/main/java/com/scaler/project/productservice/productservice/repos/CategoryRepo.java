package com.scaler.project.productservice.productservice.repos;

import com.scaler.project.productservice.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
