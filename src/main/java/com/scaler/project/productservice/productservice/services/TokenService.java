package com.scaler.project.productservice.productservice.services;

import com.scaler.project.productservice.productservice.dtos.UserDto;
import com.scaler.project.productservice.productservice.inheritencedemo.singletable.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TokenService {

    private UserDto userDto;
    private RestTemplate restTemplate;
    public TokenService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public  boolean validateToken(String token) {
        UserDto user  = restTemplate.postForObject("http://localhost:9000/users/validate/" +token , null,UserDto.class);
        return user != null;
    }
}
