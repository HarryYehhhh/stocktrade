package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private int uid;
    private String accounts;
    private String password;

}
