package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Member;
import com.example.demo.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MemberController {
    
    @Autowired
    private MemberService memberService;

    @Autowired//實作密碼加密
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register")   
    public Member register(@RequestBody Member member){
        
        String hashedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(hashedPassword);

        
        return null;
    }
}
