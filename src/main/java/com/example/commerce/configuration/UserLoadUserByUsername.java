package com.example.commerce.configuration;

import com.example.commerce.member.entity.Member;
import com.example.commerce.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserLoadUserByUsername implements UserDetailsService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Member member = memberRepository.getReferenceById(userEmail);
        if (member == null) throw new UsernameNotFoundException("찾을 수 없는 사용자입니다.");

        return (UserDetails) member;
    }
}
