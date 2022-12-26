package com.example.commerce.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

//    private final MemberService memberService;
    @Autowired
    private UserAuthenticationSuccessHandler userAuthenticationSuccessHandler;
    @Autowired
    private UserAuthenticationFailureHandler userAuthenticationFailureHandler;
    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
            .antMatchers("/"
                    ,"/member/register"
                    ,"/login/fail")
            .permitAll();

        http.authorizeRequests()
//            .antMatchers("/admin/**").hasAnyRole("ADMIN")
//            .antMatchers("/basket/**").hasAnyRole("USER")
            .anyRequest().permitAll();

        http.formLogin()
            .loginProcessingUrl("member/login")
            .usernameParameter("userEmail")
            .passwordParameter("password")
            .successHandler(userAuthenticationSuccessHandler)
            .failureHandler(userAuthenticationFailureHandler);

        http.formLogin()
                .loginPage("/member/login")
                .usernameParameter("userEmail")
                .passwordParameter("password")
                .successHandler(userAuthenticationSuccessHandler)
                .failureHandler(userAuthenticationFailureHandler)
                .permitAll();



        http.sessionManagement()
            .maximumSessions(1)
            .maxSessionsPreventsLogin(true);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
        throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
