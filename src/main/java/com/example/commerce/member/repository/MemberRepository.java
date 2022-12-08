package com.example.commerce.member.repository;

import com.example.commerce.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    boolean existsByUserEmail(String userEmail);

//    Member findByUserEmail(String userEmail);
}
