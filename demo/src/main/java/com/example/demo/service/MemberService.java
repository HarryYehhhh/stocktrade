package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member createMember(Member member){
        
        

        return memberRepository.save(member);
    }

    public Member getMemberByAccount(String account){
        return memberRepository.getMemberByAccount(account);
    }

    public Member getMemberByMemberId(Integer uid){
        return memberRepository.getMemberByMemberId(uid);
    }

}
