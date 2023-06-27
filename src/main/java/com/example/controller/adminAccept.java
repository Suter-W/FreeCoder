package com.example.controller;


import com.example.pojo.Order;
import com.example.pojo.OrderItem;
import com.example.pojo.Result;
import com.example.service.adminAcceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adminAccept")
public class adminAccept {

    @Autowired
    private adminAcceptService adminAcceptService;

    public Integer gettableID(String restID,String tableName,String tableType){
        Integer tableID = adminAcceptService.getTableID(restID,tableName,tableType);
        return (tableID);
    }

    public Integer getOrderingID(Integer tableID){
        Integer orderID = adminAcceptService.getOrderingID(tableID);
        return orderID;
    }

    @GetMapping("/getPendingList")
    public Result getPendingList(@RequestParam String restID){
        List<Order> pendingOrderList = adminAcceptService.getPendingList(restID);
        return Result.success(pendingOrderList);
    }

    @GetMapping("/getPendingOrder")
    public Result getPendingOrder(@RequestParam Integer orderID){
        Order pendingOrder = adminAcceptService.getPendingOrder(orderID);
        return Result.success(pendingOrder);
    }

    @GetMapping("/getPendingItem")
    public Result getPendingItem(@RequestParam Integer orderID){
        List<OrderItem> itemList = adminAcceptService.getPendingItem(orderID);
        return Result.success(itemList);
    }

    @PostMapping("/acceptOrder")
    public Result acceptOrder(@RequestParam Integer orderID){
        adminAcceptService.acceptOrder(orderID);
        return Result.success();
    }
}