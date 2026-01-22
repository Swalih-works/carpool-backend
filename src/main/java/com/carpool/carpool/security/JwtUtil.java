package com.carpool.carpool.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    // Secret key (used to sign token)
    private static final String SECRET =
            "my-super-secret-key-for-carpool-app-123456";

    private static final Key key =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    // Token validity (1 hour)
    private static final long EXPIRATION_TIME = 60 * 60 * 1000;

    public static String generateToken(Long userId, String role) {

        return Jwts.builder()
                .setSubject(userId.toString())
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public static Key getKey() {
        return key;
    }

}