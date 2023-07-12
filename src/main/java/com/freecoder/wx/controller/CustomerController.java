package com.freecoder.wx.controller;

import com.freecoder.response.result.ResponseResultBody;
import com.freecoder.response.result.Result;
import com.freecoder.response.result.ResultStatus;
import com.freecoder.utils.JwtUtils;
import com.freecoder.wx.model.Customer;
import com.freecoder.wx.service.CustomerService;
import io.jsonwebtoken.Claims;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Objects;

@RestController
@CrossOrigin
@PermitAll
@RequestMapping("/wxapp")
@ResponseResultBody
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers/{id}")
    public Result getCustomerInfo(@PathVariable Long id) {
        try {
            return Result.success(customerService.getCustomerInfo(id));
        } catch (Exception e) {
            return Result.failure(ResultStatus.BAD_REQUEST, "登录失败");
        }
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<? extends Result<?>> updateCustomerInfo(@RequestBody HashMap body, @PathVariable Long id,
                                                                  @RequestHeader("Authorization") String jwt) {
        //校验id是否匹配
        Claims claims = JwtUtils.parseWeChatJWT(jwt.substring(7));
        Long token_id = ((Integer) claims.get("id")).longValue();
        if (!Objects.equals(id, token_id)) {
            Result<Void> result = Result.failure(ResultStatus.BAD_REQUEST, "用户id不匹配,更新失败");
            return ResponseEntity.badRequest().body(result);
        }

        //获取更新信息
        String nickName = (String) body.getOrDefault("nickName", "微信用户");
        String avatarUrl = (String) body.getOrDefault("avatarUrl", "https://img0.baidu.com/it/u=3070762535,1739046062&fm=253&fmt=auto&app=138&f=JPEG?w=222&h=220");

        //尝试更新
        try {
            Customer customer = customerService.updateCustomerNameAndAvatar(nickName, avatarUrl, id);
            Result<Customer> result = Result.success(customer);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Result<Void> result = Result.failure(ResultStatus.FORBIDDEN, "更新失败");
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PutMapping("/customers/{id}/vip")
    public ResponseEntity<? extends Result<?>> updateCustomerVipInfo(@RequestBody HashMap body, @PathVariable Long id,
                                                                     @RequestHeader("Authorization") String jwt) {
        //校验id是否匹配
        Claims claims = JwtUtils.parseWeChatJWT(jwt.substring(7));
        Long token_id = ((Integer) claims.get("id")).longValue();
        if (!Objects.equals(id, token_id)) {
            return new ResponseEntity<>(
                    Result.failure(ResultStatus.FORBIDDEN, "用户id不匹配,更新失败"),
                    HttpStatus.FORBIDDEN
            );
        }

        System.out.println("Update Body：" + body + id);
        Boolean isVip = (Boolean) body.getOrDefault("isVip", false);

        try {
            Customer customer = customerService.updateCustomerVipInfo(isVip, id);
            return new ResponseEntity<>(
                    Result.success(ResultStatus.ACCEPTED, customer),
                    HttpStatus.ACCEPTED
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    Result.failure(ResultStatus.INTERNAL_SERVER_ERROR, "更新失败"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
