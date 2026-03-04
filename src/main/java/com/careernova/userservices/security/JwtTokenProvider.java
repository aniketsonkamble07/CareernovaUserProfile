package com.careernova.userservices.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.List;
import java.util.UUID;

@Component
public class JwtTokenProvider {

    private final String secretKey = "replace_this_with_your_256_bit_long_secret_key_for_hmac";

    private final Key key = Keys.hmacShaKeyFor(secretKey.getBytes());

    private final String AUTH_HEADER = "Authorization";
    private final String TOKEN_PREFIX = "Bearer ";

    // 1️⃣ Extract JWT from request header
    public String resolveToken(HttpServletRequest request) {
        String header = request.getHeader(AUTH_HEADER);
        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            return header.substring(TOKEN_PREFIX.length());
        }
        return null;
    }

    // 2️⃣ Validate JWT signature & expiry
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // 3️⃣ Extract userId from JWT 'sub' claim
    public UUID getUserId(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token)
                .getBody();
        return UUID.fromString(claims.getSubject());
    }

    // 4️⃣ Build Authentication object for Spring Security
    public Authentication getAuthentication(String token) {
        UUID userId = getUserId(token);
        // You can set empty authorities if roles are not needed
        return new UsernamePasswordAuthenticationToken(userId, null, List.of());
    }
}