package com.freecoder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freecoder.pojo.Result;
import com.freecoder.pojo.User;
import com.freecoder.service.AuthService;
import com.freecoder.utils.JwtUtils;
import com.freecoder.utils.Md5Utils;
import jakarta.json.Json;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import static com.freecoder.utils.RSAEncrypt.*;

@RestController
@Slf4j
public class AuthController {

    @Autowired
    private AuthService authService;


//    @PostMapping("/login")
//    public Result login(@RequestBody User user){
//        log.info("餐厅管理员登录：{}",user);
//        User e = authService.login(user);
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
//            return Result.success(jwt);
//        }
//
//        return Result.eraror("使用了错误的餐厅ID或密码");
//    }

    @PostMapping("/login")
    public Result login(@RequestBody String ciphertext) throws Exception {
//        System.out.println("body: " + ciphertext);/
//        System.out.println(ciphertext.equals("{\r\n    \"restID\":\"0000001\",\r\n    \"password\":\"123456789\"\r\n}"));
//        String pubKey = loadKey( "docs/id_rsa.pub");
//        ciphertext = encrypt(ciphertext,pubKey);
//        System.out.println("加密后的字符串为："+ ciphertext);
//

        String key = loadKey( "docs/id_rsa");
        ciphertext = URLDecoder.decode(ciphertext, "UTF-8");
        System.out.println("body: " + ciphertext);
        String messageDe = decrypt(ciphertext, key);
        System.out.println("还原后的字符串为:" + messageDe);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // 将JSON字符串转换为User对象
            User user = objectMapper.readValue(messageDe, User.class);
            System.out.println(user.getRestID());
            System.out.println(user.getPassword());
            return loginJWT(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Result.error("请求参数不符合要求");

    }
    /**
     * @Description 用于实现登录功能，以及采用了过滤器的功能，能够拦截未登录（没有获得token令牌）的用户，增强安全性
     * @param user
     * @Date 16:44 2023/7/1
     * @Param [com.freecoder.pojo.User]
     * @return com.freecoder.pojo.Result
     **/
    public Result loginJWT(@RequestBody User user) throws Exception {
        log.info("餐厅管理员登录：{}",user);
        System.out.printf("餐厅管理员登录：{\s}",user);
        User e = authService.login(user);

        if(e != null){
            Map<String, Object> clamis = new HashMap<>();
            clamis.put("restID",e.getRestID());

            String password = DigestUtils.sha256Hex(e.getPassword());  //为取到的密码进行sha256加密
            System.out.println("sha256"+password);

            clamis.put("password",password);
            String jwt = JwtUtils.generateJwt(clamis);
            return Result.success(jwt);
        }

        return Result.error("使用了错误的餐厅ID或密码");
    }

    /**
     * 新增用户(注册)
     *
     * @param user
     * @return
     */
    @PostMapping("addUser")
    public String addUser(User user){
        String password = Md5Utils.code(user.getPassword());
        System.out.println(password);
        user.setPassword(password);
        authService.insert(user);
        return "seccuss";
    }

}
