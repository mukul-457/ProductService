package com.scaler.project.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    @ManyToOne
    @JoinColumn
    private Category category;
    private double price;
    private  String description;
}
