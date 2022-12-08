package com.example.commerce.configuration;

import com.example.commerce.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    private final MemberService memberService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
            .antMatchers("/"
                    ,"/member/register")
            .permitAll();

//        http.formLogin()
//            .loginPage("member/login")
//            .permitAll();

        return http.build();
    }

}
