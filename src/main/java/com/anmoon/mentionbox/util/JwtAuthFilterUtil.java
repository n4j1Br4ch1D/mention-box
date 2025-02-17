package com.anmoon.mentionbox.util;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilterUtil extends OncePerRequestFilter {
    private final JwtUsernameUtil jwtUtils;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
       final String authHeader = request.getHeader("Authorization");
       final String jwt;
       final String username;
       if (authHeader == null || !authHeader.startsWith("Bearer ")){
           filterChain.doFilter(request, response);
           return;
       }
       jwt = authHeader.substring(7);
       username = jwtUtils.extractUsername(jwt);
    }
}
