package com.example.commerce.admin.service;

import com.example.commerce.member.entity.Member;
import com.example.commerce.member.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminMemberService {

    private final MemberRepository memberRepository;

    // member별 정보 보기
//    public List<Member> readMember(String userEmail) {
////        List<Member> members = memberRepository.findAll();
////        if(!members.isEmpty()) return memberRepository.findAll();
////        else throw new IllegalArgumentException("회원이 없습니다.");
//        return memberRepository.findAllByUserEmail(userEmail);
//    }

    public List<Member> readMembers() {
        List<Member> members = memberRepository.findAll();
        if(!members.isEmpty()) return memberRepository.findAll();
        else throw new IllegalArgumentException("회원이 없습니다.");
    }

    //회원상태수정
    public void updateStatus(String userEmail, String status) {
        Member member = memberRepository.getFirstByUserEmail(userEmail);
        member.setStatus(status);
        memberRepository.save(member);
    }

    // admin 권한 설정
    public void adminUser(String userEmail, String role) {
        Member member = memberRepository.getFirstByUserEmail(userEmail);
        member.setRole(role);
        memberRepository.save(member);
    }

}
