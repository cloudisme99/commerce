package com.example.commerce.member.service;

import com.example.commerce.member.entity.Member;
import com.example.commerce.member.model.MemberInput;
import com.example.commerce.member.repository.MemberRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
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
        member.setRole("USER");
        member.setZipcode(zipcode);
        member.setAddress(address);
        member.setRegisterDate(LocalDateTime.now());
        memberRepository.save(member);

    }

//    public void updateDetail(String userEmail, String userName, String password, String phone, String zipcode, String address) {
//
//        String userEmail = Member.
////        Optional<Member> optionalMember = memberRepository.findByUserEmail(userEmail);
////
////        if(!optionalMember.isPresent()) {
////            System.out.println("존재하지 않는 회원입니다.");
////            System.out.println(userEmail);
////        }
//
//        Member member = memberRepository.getFirstByUserEmail(userEmail);
//        member.setUserName(userName);
//        member.setPassword(password);
//        member.setPhone(phone);
//        member.setZipcode(zipcode);
//        member.setAddress(address);
//        member.setUpdateDate(LocalDateTime.now());
//    }

    //비밀번호 변경 로직
//    public void updatePassword(String userEmail) {
//        Member updateMember = memberRepository.findByUserEmail(userEmail);
//        updateMember.setUserEmail(userEmail);
//        memberRepository.save(updateMember);
//    }

    // 회원정보수정
//    @Transactional(readOnly = true)
//    public void updateDetail(String userEmail, String userName, String password, String phone, String zipcode, String address) {
//        Member member = memberRepository.getFirstByUserEmail(userEmail);
//        member.setUserName(userName);
//        member.setPassword(password);
//        member.setPhone(phone);
//        member.setZipcode(zipcode);
//        member.setAddress(address);
//        memberRepository.save(member);
//    }

//    public void updateDetail(String userEmail, MemberInput parameter) {
//
//        Optional<Member> optionalMember = memberRepository.findByUserEmail(userEmail);
//
//        if(!optionalMember.isPresent()) {
//            System.out.println("존재하지 않는 회원입니다.");
//            System.out.println(parameter.getUserName());
//        }
//
//        Member member = new Member();
//        member.setUserEmail(userEmail);
//        member.setUserName(parameter.getUserName());
//        member.setPassword(parameter.getPassword());
//        member.setPhone(parameter.getPhone());
//        member.setZipcode(parameter.getZipcode());
//        member.setAddress(parameter.getAddress());
//        member.setUpdateDate(LocalDateTime.now());
//    }
}
