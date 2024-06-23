package com.scaler.project.productservice.productservice.inheritencedemo.mappedsc;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@MappedSuperclass
public class User {
    @Id
    private long id;
    private String email;
    private String name;
}
