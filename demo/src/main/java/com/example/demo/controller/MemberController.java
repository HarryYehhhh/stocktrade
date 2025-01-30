package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Member;
import com.example.demo.service.MemberService;


@RestController
public class MemberController {
    
    @Autowired
    private MemberService memberService;

    @Autowired//實作密碼加密
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register")   
    public Member register(@RequestBody Member member){
        
        String hashedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(hashedPassword);

        Member newMember = memberService.createMember(member);

        Integer memberId = newMember.getMemberId();
        return memberService.getMemberByMemberId(memberId);
    }
}
