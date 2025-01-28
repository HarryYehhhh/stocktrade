package com.example.demo.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.model.Member;

@Component //根據使用者輸入的帳號查詢
public class MyUserDetailsService implements UserDetailsService{
    
    @Autowired
    private MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Member member = memberService.getMemberByAccount(username);

        String account = member.getAccount();
        String password = member.getPassword();

        return new User(account, password, new ArrayList<>());
    }
}
