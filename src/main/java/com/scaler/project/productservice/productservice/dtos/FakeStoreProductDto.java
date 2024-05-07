package com.scaler.project.productservice.productservice.dtos;

import com.scaler.project.productservice.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id ;
    private  String title;
    private String category;
    private  double price;
    private String  description;
    private  String image;

}
