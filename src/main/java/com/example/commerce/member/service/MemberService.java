package com.example.commerce.member.service;

import com.example.commerce.admin.AdminMemberRepository;
import com.example.commerce.member.entity.Member;
import com.example.commerce.member.repository.MemberRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final AdminMemberRepository adminMemberRepository;

    public void register(String userEmail, String userName, String password, String phone, String zipcode, String address) {

        if (memberRepository.existsByUserEmail(userEmail)) {
            System.out.println("중복된 이메일입니다.");
            throw new RuntimeException();
        }

        Member member = new Member();

        member.setUserEmail(userEmail);
        member.setUserName(userName);
        member.setPassword(password);
        member.setPhone(phone);
        member.setStatus("정상");
        member.setRole("USER");
        member.setZipcode(zipcode);
        member.setAddress(address);
        member.setRegisterDate(LocalDateTime.now());
        memberRepository.save(member);

    }

    //비밀번호 변경 로직
//    public void updatePassword(String userEmail) {
//        Member updateMember = memberRepository.findByUserEmail(userEmail);
//        updateMember.setUserEmail(userEmail);
//        memberRepository.save(updateMember);
//    }

    // 회원정보수정
//    public void updateDetail(String userEmail, String userName, String password, String phone, String zipcode, String address) {
//        Member member = adminMemberRepository.getFirstByUserEmail(userEmail);
//        member.setUserName(userName);
//        member.setPassword(password);
//        member.setPhone(phone);
//        member.setZipcode(zipcode);
//        member.setAddress(address);
//        adminMemberRepository.save(member);
//    }

}
