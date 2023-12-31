package com.freecoder.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freecoder.response.MyResult;
import com.freecoder.web.model.Restaurant;
import com.freecoder.web.service.AuthService;
import com.freecoder.utils.JwtUtils;
import jakarta.annotation.security.PermitAll;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import static com.freecoder.utils.RSAEncrypt.*;

@RestController
@Slf4j
@PermitAll
@CrossOrigin
@RequestMapping("/web")
public class AuthController {

    @Autowired
    private AuthService authService;


//    @PostMapping("/login")
//    public MyResult login(@RequestBody Restaurant user){
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
//            return MyResult.success(jwt);
//        }
//
//        return MyResult.eraror("使用了错误的餐厅ID或密码");
//    }

    @PostMapping("/login")
    public MyResult login(@RequestBody String ciphertext) throws Exception {

        //RSA解密
        String key = loadKey( "docs/id_rsa");
        ciphertext = URLDecoder.decode(ciphertext, "UTF-8");
        System.out.println("body: " + ciphertext);
        String messageDe = decrypt(ciphertext, key);
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

        return com.freecoder.response.MyResult.error("error","请求参数不符合要求");

    }
    /**
     * @Description 用于实现登录功能，以及采用了过滤器的功能，能够拦截未登录（没有获得token令牌）的用户，增强安全性
     * @param restaurant
     * @Date 16:44 2023/7/1
     * @Param [com.freecoder.model.Restaurant]
     * @return com.freecoder.response.MyResult
     **/
    public MyResult loginJWT(@RequestBody Restaurant restaurant) throws Exception {
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
            return MyResult.success("success",jwt);
        }

        return com.freecoder.response.MyResult.error("error","使用了错误的餐厅ID或密码");
    }


}
