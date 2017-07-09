package com.example.umatsu.trainingCRUD.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomLoginFilter extends UsernamePasswordAuthenticationFilter{

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {

        String username = super.obtainUsername(request);
        String password = super.obtainPassword(request);

        if ("admin".equals(username)) {
            if (!"admin".equals(password)) {
                throw new AuthenticationServiceException("Password is invalid.");
            }
        } else if ("user".equals(username)) {
            if (!"user".equals(password)) {
                throw new AuthenticationServiceException("Password is invalid.");
            }
        } else {
            throw new AuthenticationServiceException("User Name is invalid.");
        }

        CustomUsernamePasswordAuthenticationToken authRequest =
                new CustomUsernamePasswordAuthenticationToken(username, password);

        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
