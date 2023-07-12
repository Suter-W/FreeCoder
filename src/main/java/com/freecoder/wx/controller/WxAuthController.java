package com.freecoder.wx.controller;

import com.freecoder.response.result.ResponseResultBody;
import com.freecoder.response.result.Result;
import com.freecoder.response.result.ResultStatus;
import com.freecoder.wx.service.WxAuthService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@PermitAll
@RequestMapping("/wxapp")
@ResponseResultBody
public class WxAuthController {

    @Autowired
    WxAuthService authService;

    @GetMapping("/login")
    public Result login(@RequestParam String code){
        System.out.println(code);
        try {
            Result result = authService.login(code);
            return result;
        }catch (Exception e){
            return Result.failure(ResultStatus.INTERNAL_SERVER_ERROR,"登录失败");
        }
    }
}
