package com.scaler.project.productservice.productservice.inheritencedemo.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity (name = "jt_instructor")
public class Instructor extends User {
    private String module;
    private String batch;
}
