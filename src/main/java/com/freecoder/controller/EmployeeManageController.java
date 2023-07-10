package com.freecoder.controller;

import com.freecoder.model.Result;
import com.freecoder.service.EmployeeManageService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName EmployeeManageController
 * @Description TODO
 * @DATE 2023/7/10 15:05
 */

@RestController
@CrossOrigin
@PermitAll
public class EmployeeManageController {

    @Autowired
    private EmployeeManageService employeeManageService;


    @PostMapping("/wxapp/addEmploy")
    public Result addEmploy(){
        employeeManageService.addEmploy();
        return Result.success("员工申请");
    }

    @GetMapping("/web/getEmployInfo")
    public Result getEmployInfo(){
        List<String> EmployInfoList = employeeManageService.getEmployInfo();
        return Result.success(EmployInfoList);
    }

    @PostMapping("")
    public Result refineEmployInfo(){
        employeeManageService.refineEmployInfo();
        return Result.success("确认员工身份");
    }

}
