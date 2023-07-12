package com.freecoder.web.controller;


import com.freecoder.response.Result;
import com.freecoder.web.model.Employee;
import com.freecoder.web.service.AdminEmployeeService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/web/adminEmployee")
@PermitAll
@CrossOrigin
public class AdminEmployeeController {
    @Autowired
    private AdminEmployeeService adminEmployeeService;


    @GetMapping("/getEmployeeList")
    public Result getEmployeeList(@RequestParam String restID){
        List<Employee> empList = adminEmployeeService.getEmployeeList(restID);
        return Result.success(empList);
    }

    @GetMapping("/addEmployee")
    public Result addEmployee(@RequestParam String restID,
                              @RequestParam String phone_num,
                              @RequestParam String type){
        adminEmployeeService.addEmployee(restID,phone_num,type);
        return Result.success();
    }

    @DeleteMapping("/deleteEmployee")
    public Result deleteEmployee(@RequestParam String phone_num){
        adminEmployeeService.deleteEmployee(phone_num);
        return Result.success();
    }
}
