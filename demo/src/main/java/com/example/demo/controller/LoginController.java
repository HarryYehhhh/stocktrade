package com.example.demo.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
    
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome !!";
    }
    @GetMapping("/hello")
    public String hello(Authentication authentication){

        String username = authentication.getName();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        return "Hello " + username + authorities;
    }
}
