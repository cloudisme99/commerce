package com.example.commerce.member.repository;

import com.example.commerce.member.entity.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    boolean existsByUserEmail(String userEmail);

    Member getReferenceById(String userEmail);

    Member getFirstByUserEmail(String userEmail);



//    List<Member> findAll();

    //    Member findByUserEmail(String userEmail);
}
