package com.example.commerce.admin.service;

import com.example.commerce.admin.AdminMemberRepository;
import com.example.commerce.member.entity.Member;
import com.example.commerce.member.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminMemberRepository adminMemberRepository;

    public List<Member> readMember(String userEmail) {
//        List<Member> members = memberRepository.findAll();
//        if(!members.isEmpty()) return memberRepository.findAll();
//        else throw new IllegalArgumentException("회원이 없습니다.");
        return adminMemberRepository.findAllByUserEmail(userEmail);
    }

    public List<Member> readMembers() {
List<Member> members = adminMemberRepository.findAll();
        if(!members.isEmpty()) return adminMemberRepository.findAll();
        else throw new IllegalArgumentException("회원이 없습니다.");
//        return adminMemberRepository.findAllByUserEmail(userEmail);
    }

    //회원상태수정
    public void updateStatus(String userEmail, String status) {
        Member member = adminMemberRepository.getFirstByUserEmail(userEmail);
        member.setStatus(status);
        adminMemberRepository.save(member);
    }

    public void adminUser(String userEmail, String role) {
        Member member = adminMemberRepository.getFirstByUserEmail(userEmail);
        member.setRole(role);
        adminMemberRepository.save(member);
    }
}
