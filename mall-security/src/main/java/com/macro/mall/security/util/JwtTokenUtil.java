package com.macro.mall.security.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * tool class JWT token format
 * JwtToken generated: header.payload.signature
 * header format (algorithms, token type):
 * { "alg": "HS512", "typ": "JWT"}
 * payload format (username, Creation Date, generation time):
 * { "sub": "wang", "created": 1489079981393, "exp": 1489684781} signature generation algorithm:
 * HMACSHA512(base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)
 * Created by macro on 2018/4/26.
 */

public class JwtTokenUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * According to the token responsible for generating the JWT
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * Get payload in JWT from token
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            LOGGER.info("JWT format validation failed:{}", token);
        }
        return claims;
    }

    /**
     * The expiration time of the generated token
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * Get login username from token
     */
    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * Verify that the token is still valid
     *
     * @param token       Incoming token from the client
     * @param userDetails User information queried from the database
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * Determine if the token has expired
     */
    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * Get the expiration time from the token
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * Generate token based on user information
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * The token can be refreshed when the original token has not expired
     *
     * @param oldToken 带tokenHead的token
     */
    public String refreshHeadToken(String oldToken) {
        if(StrUtil.isEmpty(oldToken)){
            return null;
        }
        String token = oldToken.substring(tokenHead.length());
        if(StrUtil.isEmpty(token)){
            return null;
        }
        //token verification failed
        Claims claims = getClaimsFromToken(token);
        if(claims==null){
            return null;
        }
        //If the token has expired, refresh is not supported
        if(isTokenExpired(token)){
            return null;
        }
        //If the token has just been refreshed within 30 minutes, return to the original token
        if(tokenRefreshJustBefore(token,30*60)){
            return token;
        }else{
            claims.put(CLAIM_KEY_CREATED, new Date());
            return generateToken(claims);
        }
    }

    /**
     * Determine if the token has just been refreshed in the specified time
     * @param token The original token
     * @param time Specified time (seconds)
     */
    private boolean tokenRefreshJustBefore(String token, int time) {
        Claims claims = getClaimsFromToken(token);
        Date created = claims.get(CLAIM_KEY_CREATED, Date.class);
        Date refreshDate = new Date();
        //Refresh time within specified time of creation time
        if(refreshDate.after(created)&&refreshDate.before(DateUtil.offsetSecond(created,time))){
            return true;
        }
        return false;
    }
}
