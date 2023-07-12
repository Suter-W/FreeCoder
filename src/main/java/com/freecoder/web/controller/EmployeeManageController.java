package com.freecoder.web.controller;

import com.freecoder.response.MyResult;
import com.freecoder.web.service.EmployeeManageService;
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
    public MyResult addEmploy(){
        employeeManageService.addEmploy();
        return MyResult.success("success","员工申请");
    }

    @GetMapping("/web/getEmployInfo")
    public MyResult getEmployInfo(){
        List<String> EmployInfoList = employeeManageService.getEmployInfo();
        return com.freecoder.response.MyResult.success(EmployInfoList);
    }

    @PostMapping("")
    public MyResult refineEmployInfo(){
        employeeManageService.refineEmployInfo();
        return com.freecoder.response.MyResult.success("success","确认员工身份");
    }

}
