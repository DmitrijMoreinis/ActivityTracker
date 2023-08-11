package com.activityproject.activitytracker.security;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import java.security.SignatureException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;


@Slf4j

public class JwtTokenProvider {

    private String jwtSecret;

    public String generateToken(String name) {
        Instant now= Instant.now();
        Instant expiration = now.plus(30, ChronoUnit.DAYS);

        return Jwts.builder()
                .setSubject(name)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(expiration))
                .signWith(SignatureAlgorithm.ES256, jwtSecret)
                .compact();

        }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }

        return false;
    }




    }

