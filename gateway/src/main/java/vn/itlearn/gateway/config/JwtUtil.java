package vn.itlearn.gateway.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;

    private Key key;

    @PostConstruct
    public void init(){
        this.key= Keys.hmacShaKeyFor(secret.getBytes());
    }

    public Claims getAllClaimFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public boolean isExpired(String token){
        return this.getAllClaimFromToken(token).getExpiration().before(new Date());
    }

    public boolean isInvalid(String token){
        return this.isExpired(token);
    }
}
