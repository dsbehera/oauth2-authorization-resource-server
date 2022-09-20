package com.deepak.oauth.service;

import com.deepak.oauth.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*AppUser user = appUserRepository.findByUserName(username);
        if(user == null) {
            throw  new UsernameNotFoundException("No User Found");
        }*/
        if (!"admin".equals(username)) {
            throw  new UsernameNotFoundException("No User Found");
        }

        return new User(
                username,
                passwordEncoder.encode("password"),
                true,
                true,
                true,
                true,
                getAuthorities()
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.of("read", "write")
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
