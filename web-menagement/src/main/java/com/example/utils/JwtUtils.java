package com.example.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    // 签名密钥
    private static final String SECRET_KEY = "tutu";
    // token有效期（6小时）
    private static final long EXPIRE_TIME = 6 * 60 * 60 * 1000;

    /**
     * 生成JWT令牌
     * @param claims JWT第二部分负载 payload 中存储的内容
     * @return JWT令牌
     */
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    /**
     * 解析JWT令牌
     * @param token JWT令牌
     * @return JWT第二部分负载 payload 中存储的内容
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 判断token是否过期
     * @param token JWT令牌
     * @return true 已过期，false 未过期
     */
    public static boolean isExpired(String token) {
        try {
            Claims claims = parseToken(token);
            return claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return true;
        }
    }

    public static Integer getUserId(String token) {
        Claims claims = parseToken(token);
        Object idObj = claims.get("id");
        if (idObj != null) {
            return Integer.valueOf(idObj.toString());
        }
        return null;
    }
}