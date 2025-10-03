package com.wheeler.app.service;

import com.wheeler.app.model.AppUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class jwtUtil {
    @Value("${jwt.secret}") // add in applicatoin.properties if not there
    private String secretKey;
    @Value("${jwt.expiration}")// add in applicatoin.properties if not there
    private long ExpirationTime;

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    // generating token
    public String generateJwtToken(AppUser user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", user.getName());
        claims.put("role", user.getRole());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(String.valueOf(user.getEmail()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + ExpirationTime))
                .signWith(getSigningKey())
                .compact();
    }

    // extract Claims
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
    }
    // extract subject
    public String extractSubject(String token) {
        return extractAllClaims(token).getSubject();// returns the user email
    }
    // extract role
    public String extractRole(String token) {
        return extractAllClaims(token).get("role").toString();
    }
    //extract username
    public String extractUsername(String token) {
        return extractAllClaims(token).get("username").toString();
    }
    //check for token Expiration
    public Boolean isTokenExpired(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getExpiration().before(new Date());
    }
    //validate token
    public boolean isTokenValid(String token,String userName) {
        return extractSubject(token).equals(userName);
    }


}
