package com.freecoder.controller;

import com.freecoder.pojo.Result;
import com.freecoder.pojo.User;
import com.freecoder.service.adminLoginService;
import com.freecoder.utils.JwtUtils;
import com.freecoder.utils.Md5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class AuthController {

    @Autowired
    private adminLoginService adminLoginService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("餐厅管理员登录：{}",user);
        User e = adminLoginService.login(user);

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
        adminLoginService.insert(user);
        return "seccuss";
    }

}
