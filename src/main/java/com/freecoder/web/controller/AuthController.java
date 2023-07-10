package com.freecoder.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freecoder.web.model.Restaurant;
import com.freecoder.web.model.Result;
import com.freecoder.web.service.AuthService;
import com.freecoder.utils.JwtUtils;
import com.freecoder.utils.Md5Utils;
import com.freecoder.utils.RSAEncrypt;
import jakarta.annotation.security.PermitAll;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@PermitAll
@CrossOrigin
@RequestMapping("/web")
public class AuthController {

    @Autowired
    private AuthService authService;


//    @PostMapping("/login")
//    public Response login(@RequestBody Restaurant user){
//        log.info("餐厅管理员登录：{}",user);
//        Restaurant e = authService.login(user);
//
//        if(e != null){
//            Map<String, Object> clamis = new HashMap<>();
//            clamis.put("restID",e.getRestID());
//
//            String password = DigestUtils.sha256Hex(e.getPassword());  //为取到的密码进行sha256加密
//            System.out.println(password);
//
//            clamis.put("password",password);
//            String jwt = JwtUtils.generateJwt(clamis);
//            return Response.success(jwt);
//        }
//
//        return Response.eraror("使用了错误的餐厅ID或密码");
//    }

    @PostMapping("/login")
    public Result login(@RequestBody String ciphertext) throws Exception {
//        System.out.println("body: " + ciphertext);/
//        System.out.println(ciphertext.equals("{\r\n    \"restID\":\"0000001\",\r\n    \"password\":\"123456789\"\r\n}"));
//        String pubKey = loadKey( "docs/id_rsa.pub");
//        ciphertext = encrypt(ciphertext,pubKey);
//        System.out.println("加密后的字符串为："+ ciphertext);
//

        //RSA解密
        String key = RSAEncrypt.loadKey( "docs/id_rsa");
        ciphertext = URLDecoder.decode(ciphertext, "UTF-8");
        System.out.println("body: " + ciphertext);
        String messageDe = RSAEncrypt.decrypt(ciphertext, key);
        System.out.println("还原后的字符串为:" + messageDe);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // 将JSON字符串转换为User对象
            Restaurant restaurant = objectMapper.readValue(messageDe, Restaurant.class);
            System.out.println(restaurant.getRestID());
            System.out.println(restaurant.getPassword());
            return loginJWT(restaurant);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Result.error("请求参数不符合要求");

    }
    /**
     * @Description 用于实现登录功能，以及采用了过滤器的功能，能够拦截未登录（没有获得token令牌）的用户，增强安全性
     * @param restaurant
     * @Date 16:44 2023/7/1
     * @Param [com.freecoder.web.model.Restaurant]
     * @return com.freecoder.web.model.Response
     **/
    public Result loginJWT(@RequestBody Restaurant restaurant) throws Exception {
        log.info("餐厅管理员登录：{}", restaurant);
        System.out.printf("餐厅管理员登录：{\s}", restaurant);
        Restaurant e = authService.login(restaurant);

        if(e != null){
            Map<String, Object> clamis = new HashMap<>();
            clamis.put("restID",e.getRestID());

            String password = DigestUtils.sha256Hex(e.getPassword());  //为取到的密码进行sha256加密
            System.out.println("sha256"+password);

            clamis.put("password",password);
            String jwt = JwtUtils.generateWebJwt(clamis);
            return Result.success(jwt);
        }

        return Result.error("使用了错误的餐厅ID或密码");
    }

    /**
     * 新增用户(注册)
     *
     * @param restaurant
     * @return
     */
    @PostMapping("addUser")
    public String addUser(Restaurant restaurant){
        String password = Md5Utils.code(restaurant.getPassword());
        System.out.println(password);
        restaurant.setPassword(password);
        authService.insert(restaurant);
        return "seccuss";
    }

}
