package com.disha.hms.config;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

  //  private final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    
	private String SECRET;
	
	public JwtUtil()
	{
		SECRET = generateSecretKey();
	}
	
	public String generateSecretKey()
	{
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
			SecretKey secretKey = keyGen.generateKey();
			System.out.println("secretKey:: "+secretKey);
			return Base64.getEncoder().encodeToString(secretKey.getEncoded());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
    
    private Key getSigningKey() {
    	byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
               // .signWith(SECRET_KEY)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public boolean isTokenValid(String token) {
        return !getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                //.setSigningKey(SECRET_KEY)
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}

