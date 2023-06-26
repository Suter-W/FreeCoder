package com.example.controller;


import com.example.pojo.Result;
import com.example.pojo.table;
import com.example.service.adminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class adminOrder {

    @Autowired
    private adminOrderService adminOrderService;

    @GetMapping("/getTableList")
    public Result tableList(@RequestParam String restID){

        List<table> tableList = adminOrderService.tableList(restID);
        System.out.println(tableList);
        return Result.success(tableList);
    }

    @PostMapping("/addTable")
    public Result AddTable(@RequestBody table table){
        adminOrderService.addTable(table);
        System.out.println(table);
        return Result.success();

    }
}
