package com.example.manageclub;

import com.example.manageclub.model.mystudentdetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class jwtUtil {
    private final String SECRET = "TEAM14ISTHECOOLESTTEAMEVERFUCKEVERYONEELSEKJSITISTHENUMBERONECOLLEGEBUTFROMTHEBOTTOMFUCKTHISCOLLEGESHITCOLLEGEDONTEVERCOMEHERETHEYWILLSCAMYOUBASEDONTHEGOODWILLOFSOMAIYAVIDYAVIHARIFYOUWANTTOTAKEADMISSIONTAKEITINVIDYAVIHARTHISCOLLEGEISSHITANDPLACEMENTSAAAGHDONTTALKABOUTPLACEMENTS";

    public String generatetoken(mystudentdetails student) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("Role", student.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(student.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();

    }
    public String extractUsername(String token){
        return extractAllClaims(token).getSubject();
    }
    public String extractRole(String token){
        return (String) extractAllClaims(token).get("Role");
    }
    public boolean isTokenExpired(String token){
        return extractAllClaims(token).getExpiration().before(new Date());
    }
    public boolean validation(String token, String username){
        return (extractUsername(token).equals(username)&&!isTokenExpired(token));
    }

}
