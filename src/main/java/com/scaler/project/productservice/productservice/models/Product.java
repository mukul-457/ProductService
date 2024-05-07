package com.scaler.project.productservice.productservice.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String title;
    private Category category;

    private double price;

    private  String description;

}
