package com.scaler.project.productservice.productservice.security;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;

//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
//                                //.requestMatchers("/products/id").hasAuthority("SCOPE_ADMIN")
//                                .anyRequest().permitAll()
//                )
//                .oauth2ResourceServer((oauth2)->oauth2.jwt(Customizer.withDefaults()));
//        return http.build();
//    }
//}
