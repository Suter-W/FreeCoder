package com.example.controller;


import com.example.pojo.Order;
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
    public Result editTable(@RequestBody Table table,@RequestParam Integer tableID){
        String tableName = table.getTableName();
        Integer tableLimit = table.getTableLimit();
        String tableType = table.getTableType();
        adminOrderService.editTable(tableName,tableType,tableLimit,tableID);
        return(Result.success());
    }

    @GetMapping("/getTableInfo")
    public Result getTableInfo(@RequestParam String restID,@RequestParam String tableName,@RequestParam String tableType){
        Table table = adminOrderService.getTableInfo(restID,tableName,tableType);
        return(Result.success(table));
    }

    @DeleteMapping("/deleteTable")
    public Result deleteTable(@RequestParam Integer tableID){
        adminOrderService.deleteTable(tableID);
        return Result.success();
    }

    public Integer gettableID(String restID,String tableName,String tableType){
        Integer tableID = adminOrderService.getTableID(restID,tableName,tableType);
        return (tableID);
    }

    public Integer getOrderingID(Integer tableID){
        Integer orderID = adminOrderService.getOrderingID(tableID);
        return orderID;
    }

    @PostMapping("/getOrderInfo")
    public Result getOrderInfo(@RequestParam String restID,@RequestParam String tableName,@RequestParam String tableType){
        Integer tableID = gettableID(restID,tableName,tableType);
        Integer orderID = getOrderingID(tableID);
        Order orderInfo = adminOrderService.getOrderInfo(orderID);
        return Result.success(orderInfo);
    }
}
