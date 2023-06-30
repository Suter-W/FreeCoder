package com.freecoder.controller;


import com.freecoder.pojo.Order;
import com.freecoder.pojo.OrderItem;
import com.freecoder.pojo.Result;
import com.freecoder.pojo.Table;
import com.freecoder.service.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adminOrder")
public class AdminOrderController {
//
    @Autowired
    private AdminOrderService adminOrderService;

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
    public Result editTable(@RequestBody Table table){
        adminOrderService.editTable(table);
        return(Result.success());
    }

    //通过餐厅ID、桌子ID和桌子的类型对应点单页面的每一个桌子，用于获取tableInfo表的全部内容并进行展示

    @GetMapping("/getTableInfo")
    public Result getTableInfo(@RequestParam Integer tableID){
        Table table = adminOrderService.getTableInfo(tableID);
        return(Result.success(table));
    }


    //对创建的桌子进行删除操作

    @DeleteMapping("/deleteTable")
    public Result deleteTable(@RequestParam Integer tableID){
        adminOrderService.deleteTable(tableID);
        return Result.success();
    }


    //取出订单信息
    @PostMapping("/getOrderInfo")
    public Result getOrderInfo(@RequestParam Integer tableID){
        Integer orderID = getOrderingID(tableID);
        Order orderInfo = adminOrderService.getOrderInfo(orderID);
        return Result.success(orderInfo);
    }
    //取出订单具体项
    @PostMapping("/getOrderItem")
    public Result getOrderItem(@RequestParam Integer tableID){
        Integer orderID = getOrderingID(tableID);
        List<OrderItem> orderItem = adminOrderService.getOrderItem(orderID);
        return Result.success(orderItem);
    }
}
