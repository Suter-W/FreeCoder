package com.freecoder.wx.controller;

import com.freecoder.response.result.ResponseResultBody;
import com.freecoder.response.result.Result;
import com.freecoder.response.result.ResultException;
import com.freecoder.response.result.ResultStatus;
import com.freecoder.utils.JwtUtils;
import com.freecoder.wx.mapper.RestaurantRepository;
import com.freecoder.wx.model.Employee;
import com.freecoder.wx.model.EmployeeType;
import com.freecoder.wx.model.Restaurant;
import com.freecoder.wx.service.EmployeeService;
import io.jsonwebtoken.Claims;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Objects;

@RestController
@CrossOrigin
@PermitAll
@RequestMapping("/wxapp")
@ResponseResultBody
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RestaurantRepository restaurantRepository;

    @GetMapping("/employees/{id}")
    public Result getEmployeeInfo(@PathVariable Long id) {
        try {
            return Result.success(employeeService.getEmployeeInfo(id));
        } catch (Exception e) {
            return Result.failure(ResultStatus.BAD_REQUEST, "查询失败");
        }
    }

    @GetMapping("/employees/rest/{restId}")
    public Result getEmployeeInfo(@PathVariable String restId) {
        try {
            return Result.success(employeeService.getRestEmployees(restId));
        } catch (Exception e) {
            return Result.failure(ResultStatus.BAD_REQUEST, "查询失败");
        }
    }

    @DeleteMapping("/employees/{employeeId}/rest/{restId}")
    public Result getEmployeeInfo(@PathVariable Long employeeId, @PathVariable String restId) throws ResultException {
        try {
            return Result.success(ResultStatus.NO_CONTENT,employeeService.deleteRestEmployees(employeeId,restId));
        } catch (Exception e) {
            if (e instanceof ResultException) {
                throw e;
            }
            return Result.failure(ResultStatus.BAD_REQUEST, "删除失败");
        }
    }


    /**
     * @param body 一个json字典 包含 nickname, avatarUrl 和 phoneNum
     * @param id
     * @param jwt
     *
     * @return
     */
    @PutMapping("/employees/{id}")
    public ResponseEntity<? extends Result<?>> updateEmployeeInfo(@RequestBody HashMap body, @PathVariable Long id,
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
        String phoneNum = (String) body.getOrDefault("phoneNum", "");

        //尝试更新
        try {
            Employee employee = employeeService.updateByEmployee(nickName, avatarUrl, phoneNum, id);
            Result<Employee> result = Result.success(employee);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Result<Void> result = Result.failure(ResultStatus.FORBIDDEN, "请求id不匹配，更新失败");
            return ResponseEntity.badRequest().body(result);
        }
    }

    /**
     * @param body   一个json字典 包含 type 和 restId
     * @param restId 餐厅号
     *
     * @return
     */
    @PutMapping("/employees/rest/{restId}")
    public ResponseEntity<? extends Result<?>> updateEmployeeRestInfo(@RequestBody HashMap body, @PathVariable String restId) {
        //获取更新信息
        String type = (String) body.getOrDefault("type", null);
        String phoneNum = (String) body.getOrDefault("phoneNum", "");

        Restaurant restaurant = restaurantRepository.findByRestID(restId);

        System.out.println("restId: " + restId);
        System.out.println("phoneNum: " + phoneNum);
        System.out.println(restaurant.getRestID());

        //尝试更新
        try {
            Employee employee = employeeService.updateByAdmin(EmployeeType.valueOf(String.valueOf(type)), restaurant, phoneNum);
            Result<Employee> result = Result.success(employee);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            Result<Void> result = Result.failure(ResultStatus.FORBIDDEN, "更新失败");
            return ResponseEntity.badRequest().body(result);
        }
    }
}
