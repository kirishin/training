package com.example.umatsu.trainingCRUD.security;

import java.util.Collections;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        if ("admin".equals(authentication.getName())) {
            return new UsernamePasswordAuthenticationToken(null, null,
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));
        } else if ("user".equals(authentication.getName())) {
            return new UsernamePasswordAuthenticationToken(null, null,
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
        } else {
            throw new AuthenticationServiceException("Authentication Error");
        }
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

}
