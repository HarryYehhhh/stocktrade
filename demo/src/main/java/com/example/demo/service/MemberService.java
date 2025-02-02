package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Member;
import com.example.demo.model.Role;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member createMember(Member member){
        return memberRepository.save(member);
    }

    public Member getMemberByAccount(String email){
        return memberRepository.getMemberByEmail(email);
    }

    public Member getMemberByMemberId(Integer uid){
        return memberRepository.getMemberByMemberId(uid);
    }

    public List<Role> getRolesByMemberId(Integer memberId) {

        return memberRepository.findRolesByMemberId(memberId);
    }
}
