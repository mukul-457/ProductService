package com.scaler.project.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Category extends BaseModel {
    private String title;
//    @OneToMany(mappedBy = "category")
//    private List<Product> productList;
}
