package com.example.commerce.admin;

import com.example.commerce.member.entity.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMemberRepository extends JpaRepository<Member, String> {
    List<Member> findAllByUserEmail(String userEmail);

    //status 수정
    Member getFirstByUserEmail(String userEmail);
}
