package com.scaler.project.productservice.productservice.inheritencedemo.tableperclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Entity(name = "tpc_user")
public class User {
    @Id
    private long id;
    private String email;
    private String name;
}
