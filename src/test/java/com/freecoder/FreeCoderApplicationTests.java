package com.freecoder;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
@Slf4j
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

    @Test
    public void md5Tests(){
        // 关于DigestUtils工具类
        // 在spring系列包中的DigestUtils工具类只有md5算法的api
        // 在commons-code系列包中的DigestUtils工具类中有md系列和sha家族的多种算法的api
        String password = "1234";
        String encodePassword = DigestUtils.md5Hex(password);
        System.out.println("[md5] encode password=" + encodePassword);

    }

    @Test
    void sha256Tests() {
        String password = "1234";
        String encodePassword = DigestUtils.sha256Hex(password);
        System.out.println("[sha-256] encode password=" + encodePassword);
    }

//    @Test
//    void testBCryptPasswordEncoder() {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        /**
//         * encode()：加密方法，传入一个明文，加密后返回一个密文
//         * 同一明文，每次调用encode()方法生成出来的密文都是不一样的，
//         * 因为内部进行加密的时候，会生成一个【随机的加密盐】，
//         * 底层是通过【加密盐】和原文进行一系列处理之后再进行加密
//         * 这样的话，虽然明文一样，但是每一次的密文都是不一样的
//         */
//        String encode_pwd_1 = passwordEncoder.encode("rabbit");
//        String encode_pwd_2 = passwordEncoder.encode("rabbit");
//        log.info("encode_pwd_1:{}", encode_pwd_1);
//        log.info("encode_pwd_2:{}", encode_pwd_2);
//    }
//
//    @Test
//    void testBCryptPasswordMatcher() {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        boolean flag_true = passwordEncoder.
//                matches("rabbit", "$2a$10$y0BfZLO825XK4qRe2vxsHOv8MdcLcSqU61v0t.dHr.jEPJDxNC83i");
//
//        boolean flag_false = passwordEncoder.
//                matches("rabbit", "$2a$10$MBcThIW7Tqm9liaBAXooPepAeovbD8XbM1tV3xvHOA6FHaI6vD4hO");
//
//        log.info("flag_true:{}", flag_true);
//        log.info("flag_false:{}", flag_false);
//
//    }





}
