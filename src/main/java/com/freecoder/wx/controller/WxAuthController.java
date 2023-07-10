package com.freecoder.wx.controller;

import com.freecoder.web.model.Result;
import com.freecoder.wx.service.WxAuthService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@PermitAll
@RequestMapping("/wxapp")
public class WxAuthController {

    @Autowired
    WxAuthService authService;

    @GetMapping("/login")
    @ResponseBody
    public ResponseEntity<String> login(@RequestBody String code){
        System.out.println(code);
        try {
            Result result = authService.login(code);
            return ResponseEntity.ok(result.toString());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
