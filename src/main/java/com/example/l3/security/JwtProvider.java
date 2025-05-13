package com.example.l3.security;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public interface JwtProvider {
    String generateToken(String username);

    String extractUsername(String token);

    Date extractExpiration(String token);

    boolean validateToken(String token, UserDetails userDetails);
}
