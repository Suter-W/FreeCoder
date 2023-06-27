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
//
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
    //通过餐厅ID、桌子ID和桌子的类型对应点单页面的每一个桌子，用于获取tableInfo表的全部内容并进行展示
    @GetMapping("/getTableInfo")
    public Result getTableInfo(@RequestParam String restID,@RequestParam String tableName,@RequestParam String tableType){
        Table table = adminOrderService.getTableInfo(restID,tableName,tableType);
        return(Result.success(table));
    }

    //对创建的桌子进行删除操作
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
