package com.security.test1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)throws Exception{
        http.authorizeRequests()
                .antMatchers("/api/v1/account/my-account","/api/v1/account/my-loan").authenticated()
                .antMatchers("/api/v1/account/notice").permitAll()
                .and().formLogin().and().httpBasic();
        return http.build();
    }
}
