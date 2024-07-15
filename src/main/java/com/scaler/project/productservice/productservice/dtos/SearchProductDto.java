package com.scaler.project.productservice.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchProductDto {
    private String title;
    private int page;
    private int size;
}
