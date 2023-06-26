package com.example.controller;


import com.example.pojo.Result;
import com.example.pojo.Table;
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

        List<Table> tableList = adminOrderService.tableList(restID);
        System.out.println(tableList);
        return Result.success(tableList);
    }
    @PostMapping("/addTable")
    public Result addTable(@RequestBody Table table){
        adminOrderService.addTable(table);
        return(Result.success()) ;
    }
    @PostMapping("/editTable")
    public Result editTable(@RequestBody Table table,@RequestParam Integer id){
        String tableID = table.getTableID();
        Integer tableLimit = table.getTableLimit();
        String tableType = table.getTableType();
        adminOrderService.editTable(tableID,tableType,tableLimit,id);
        return(Result.success());
    }

    @GetMapping("/getTableInfo")
    public Result getTableInfo(@RequestParam String restID,@RequestParam String tableID,@RequestParam String tableType){
        Table table = adminOrderService.getTableInfo(restID,tableID,tableType);
        return(Result.success(table));
    }

    @DeleteMapping("/deleteTable")
    public Result deleteTable(@RequestParam Integer ID){
        adminOrderService.deleteTable(ID);
        return Result.success();
    }
}
