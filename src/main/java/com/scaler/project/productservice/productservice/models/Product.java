package com.scaler.project.productservice.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ManyToAny;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
    private double price;
    private  String description;
    private int Quantity;
}
