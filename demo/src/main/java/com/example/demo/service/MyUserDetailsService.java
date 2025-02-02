package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.model.Member;
import com.example.demo.model.Role;

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
            String email = member.getEmail();
            String password = member.getPassword();

            List<Role> roleList = memberService.getRolesByMemberId(member.getMemberId());
            //權限設定
            List<GrantedAuthority> authorities = convertToAuthorities(roleList);
            return new User(email, password, authorities);
        }
    }
    
    //將role轉換為spring security指定格式
    private List<GrantedAuthority> convertToAuthorities(List<Role> roleList){
        List<GrantedAuthority> authorities = new ArrayList<>();

        for(Role role : roleList){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }
}
