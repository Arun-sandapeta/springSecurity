package com.neoteric.springsecurity;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;

        if (token.getPrincipal().toString().equalsIgnoreCase("arun") && token.getCredentials().toString().equalsIgnoreCase("1234")){
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(token.getPrincipal(),token.getCredentials(),new ArrayList<>());
            return authenticationToken;
        }
        throw new BadCredentialsException("Invalid Username and Password");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
