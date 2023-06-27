package com.example.controller;


import com.example.pojo.Order;
import com.example.pojo.OrderItem;
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

    //下面两个gettableID与getOrderingID方法用于内部，作用为提取对应的tableID和正在进行的订单ID
    public Integer gettableID(String restID,String tableName,String tableType){
        Integer tableID = adminOrderService.getTableID(restID,tableName,tableType);
        return (tableID);
    }

    public Integer getOrderingID(Integer tableID){
        Integer orderID = adminOrderService.getOrderingID(tableID);
        return orderID;
    }

    //tableList为点餐页面开始罗列桌所用，提取该restID下的所有桌
    @GetMapping("/getTableList")
    public Result tableList(@RequestParam String restID){

        List<Table> tableList = adminOrderService.tableList(restID);
        System.out.println(tableList);
        return Result.success(tableList);
    }
    //addTable为添加桌
    @PostMapping("/addTable")
    public Result addTable(@RequestBody Table table){
        adminOrderService.addTable(table);
        return(Result.success()) ;
    }

    //editTable为编辑桌
    @PostMapping("/editTable")
    public Result editTable(@RequestBody Table table,@RequestParam String restID0,@RequestParam String tableName0,@RequestParam String tableType0){
        Integer tableID = gettableID(restID0,tableName0,tableType0);
        String tableName = table.getTableName();
        Integer tableLimit = table.getTableLimit();
        String tableType = table.getTableType();
        adminOrderService.editTable(tableName,tableType,tableLimit,tableID);
        return(Result.success());
    }
    //getTableInfo为展示当前桌信息
    @GetMapping("/getTableInfo")
    public Result getTableInfo(@RequestParam String restID,@RequestParam String tableName,@RequestParam String tableType){
        Table table = adminOrderService.getTableInfo(restID,tableName,tableType);
        return(Result.success(table));
    }

    //删除桌
    @DeleteMapping("/deleteTable")
    public Result deleteTable(@RequestParam String restID,@RequestParam String tableName,@RequestParam String tableType){
        Integer tableID = gettableID(restID,tableName,tableType);
        adminOrderService.deleteTable(tableID);
        return Result.success();
    }


    //取出订单信息
    @PostMapping("/getOrderInfo")
    public Result getOrderInfo(@RequestParam String restID,@RequestParam String tableName,@RequestParam String tableType){
        Integer tableID = gettableID(restID,tableName,tableType);
        Integer orderID = getOrderingID(tableID);
        Order orderInfo = adminOrderService.getOrderInfo(orderID);
        return Result.success(orderInfo);
    }
    //取出订单具体项
    @PostMapping("/getOrderItem")
    public Result getOrderItem(@RequestParam String restID,@RequestParam String tableName,@RequestParam String tableType){
        Integer tableID = gettableID(restID,tableName,tableType);
        Integer orderID = getOrderingID(tableID);
        List<OrderItem> orderItem = adminOrderService.getOrderItem(orderID);
        return Result.success(orderItem);
    }
}
