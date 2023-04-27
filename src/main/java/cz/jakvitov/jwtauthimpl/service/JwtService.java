package cz.jakvitov.jwtauthimpl.service;

import cz.jakvitov.jwtauthimpl.security.model.UserDetailsImpl;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface JwtService {

    String extractUserName(String token);

    Date extractExpiration(String token);

    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    Claims extractAllClaims(String token);

    Boolean isTokenExpired(String token);

    String generateToken(UserDetails userDetails);

    String createToken(Map<String, Object> claims, String subject);

    Boolean validateToken(String token, UserDetails userDetails);
}
