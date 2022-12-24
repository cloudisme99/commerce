package com.example.commerce.member.repository;

import com.example.commerce.member.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    boolean existsByUserEmail(String userEmail);

    Member getReferenceById(String userEmail);

    Optional<Member> findByUserEmail(String userEmail);

    //status 수정
    Member getFirstByUserEmail(String userEmail);

    Member getFirstByUserId(String userId);
}
