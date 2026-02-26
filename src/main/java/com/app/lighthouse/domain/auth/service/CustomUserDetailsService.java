package com.app.lighthouse.domain.auth.service;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * Oracle DB 연동 전 임시 구현.
 * Oracle user 테이블 연동 시 MyBatis Mapper로 교체 예정.
 */
@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO: Oracle lh_user 테이블 연동으로 교체
        if ("admin".equals(username)) {
            return new User(
                    "admin",
                    passwordEncoder.encode("admin"),
                    List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))
            );
        }

        throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
    }
}
