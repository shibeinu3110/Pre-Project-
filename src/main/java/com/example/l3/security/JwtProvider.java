package com.example.l3.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtProvider {
    String generateToken(String username);
    String extractUsername(String token);
    boolean validateToken(String token, UserDetails userDetails);
}
