package com.freecoder.controller;

import com.freecoder.pojo.Result;
import com.freecoder.pojo.User;
import com.freecoder.service.AuthService;
import com.freecoder.utils.JwtUtils;
import com.freecoder.utils.Md5Utils;
import jakarta.annotation.security.PermitAll;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@PermitAll
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * @Description 用于实现登录功能，以及采用了过滤器的功能，能够拦截未登录（没有获得token令牌）的用户，增强安全性
     * @param user
     * @Date 16:44 2023/7/1
     * @Param [com.freecoder.pojo.User]
     * @return com.freecoder.pojo.Result
     **/
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("餐厅管理员登录：{}",user);
        User e = authService.login(user);

        if(e != null){
            Map<String, Object> clamis = new HashMap<>();
            clamis.put("restID",e.getRestID());
            clamis.put("password",e.getPassword());
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
