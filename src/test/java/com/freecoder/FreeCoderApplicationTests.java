package com.freecoder;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class FreeCoderApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 生成Jwt
     */
    @Test
    public void testGenJwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");

        String Jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"suixincoder")   //签名算法
                .setClaims(claims)    //自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis() + 3600*1000))   //设置有效期为一个小时
                .compact();
        System.out.println(Jwt);
    }

    /**
     * 解析Jwt
     */
    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("suixincoder")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY4NzkzNzYxMn0.QgYnKX3cMe7KXz7pMF9HSKjyUjD8Fvub9TSou3YdDHc")
                .getBody();
        System.out.println(claims);
    }
}
