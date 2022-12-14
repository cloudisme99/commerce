package com.example.commerce.member.service;

import com.example.commerce.member.entity.Member;
import com.example.commerce.member.repository.MemberRepository;
import java.time.LocalDateTime;
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
        member.setAdminYn(false);
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


}
