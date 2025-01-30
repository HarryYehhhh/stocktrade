package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
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

        if (member == null){
            throw new UsernameNotFoundException(username + "is not exist");
        }else{
            String account = member.getAccount();
            String password = member.getPassword();
            //權限設定
            List<GrantedAuthority> auth = new ArrayList<>();
            return new User(account, password, auth);
        }



    }
}
