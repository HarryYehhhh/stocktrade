package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Member;
import com.example.demo.model.Role;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    
    Member getMemberByEmail(String email);
    Member getMemberByMemberId(Integer id);
    @Query("SELECT m.roles FROM Member m WHERE m.memberId = :memberId")
    List<Role> findRolesByMemberId(Integer memberId);
} 
