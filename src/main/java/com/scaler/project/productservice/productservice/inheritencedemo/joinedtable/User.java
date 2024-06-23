package com.scaler.project.productservice.productservice.inheritencedemo.joinedtable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Getter
@Setter
//@Inheritance(strategy = InheritanceType.JOINED)
//@Entity(name = "jt_user")
public class User {
    @Id
    private long id;
    private String email;
    private String name;
}
