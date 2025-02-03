package com.shs.SHS.Ecommerce.security;

import com.shs.SHS.Ecommerce.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

@Service
@Slf4j
public class JwtUtils {

    private static final long EXPIRATION_TIME_IN_MILLISEC = 1000L * 60L * 24L * 30L * 6L; // 6 months
    private SecretKey secretKey;

    @Value("${secreteJwtString}")
    private String secreteJwtString; // value for application properties (32 chars or long)

    @PostConstruct
    private void init(){
        byte[] keyBytes = secreteJwtString.getBytes(StandardCharsets.UTF_8);
        this.secretKey = new SecretKeySpec(keyBytes, "HmacSHA256");
    }

    public String generateToken(User user){
        String username = user.getEmail();
        return generateToken(username);
    }

    public String generateToken(String username){
        return Jwts.builder().subject(username).issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_IN_MILLISEC))
                .signWith(secretKey).compact();
    }

    public String getUsernameFromToken(String token){
        return extractClaims(token, Claims::getSubject);
    }
    private <T> T extractClaims(String token , Function<Claims,T> claimsResolver){
        return claimsTFunction.apply(Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload());

    }
}
