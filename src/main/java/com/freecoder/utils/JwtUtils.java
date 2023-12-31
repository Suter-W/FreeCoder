package com.freecoder.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;
import java.util.Map;


public class JwtUtils {
//两种密钥生成方式
    // 1. 随机生成一个256 bit密钥，每次重启服务端程序将自动修改密钥，使得之前生成用户token失效，只能用于单一服务器生成密钥
//    private static SecretKey signKey = Keys.secretKeyFor(SignatureAlgorithm.HS256); //签名密钥

    // 2，指定一个字符串用于生成密钥

    private static String signWebKey = DigestUtils.sha256Hex("free.coder.com");

//    private static String signWeChatKey = DigestUtils.sha256Hex("free.coder.wechat.com");

    private static Long expire = 43200000L; //过期时间12h


    /**
     * 生成JWT令牌
     *
     * @param claims JWT第二部分负载 payload 中存储的内容
     * @return
     */
    public static String generateWebJwt(Map<String, Object> claims) {
        String jwt = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signWebKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
        System.out.println("这是密钥内容" + signWebKey);
        return jwt;
    }

    /**
     * 解析JWT令牌
     *
     * @param jwt JWT令牌
     * @return JWT第二部分负载 payload 中存储的内容
     */
    public static Claims parseWebJWT(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(signWebKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }

    public static String generateWeChatJwt(Map<String, Object> claims) {
        String jwt = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signWebKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
        System.out.println("这是密钥内容" + signWebKey);
        return jwt;
    }

    public static Claims parseWeChatJWT(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(signWebKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
