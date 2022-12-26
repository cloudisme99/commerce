package com.example.commerce.configuration;

import com.example.commerce.member.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserLoadUserByUsername userLoadUserByUsername;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication)
        throws AuthenticationException {
        Member member = (Member) userLoadUserByUsername.loadUserByUsername(authentication.getName().toString());

        String reqPassword = authentication.getCredentials().toString();
        if (!passwordEncoder.matches(reqPassword, member.getPassword())) throw new BadCredentialsException("사용자를 찾을 수 없습니다.");

        return new UsernamePasswordAuthenticationToken(member, null, member.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

}
