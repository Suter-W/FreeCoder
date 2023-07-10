package com.freecoder.web.controller;


import com.freecoder.web.model.Order;
import com.freecoder.web.model.OrderItem;
import com.freecoder.web.model.Result;
import com.freecoder.web.service.AdminAcceptService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/web/adminAccept")
@PermitAll
@CrossOrigin
public class AdminAcceptController {

    @Autowired
    private AdminAcceptService adminAcceptService;

    /**
     * @Description //TODO
     * @param restID
     * @param tableName
     * @param tableType
     * @Date 11:42 2023/7/1
     * @Param [java.lang.String, java.lang.String, java.lang.String]
     * @return java.lang.Integer
     **/
    public Integer gettableID(String restID,String tableName,String tableType){
        Integer tableID = adminAcceptService.getTableID(restID,tableName,tableType);
        return (tableID);
    }

    /**
     * 内部用法获取订单编号
     * @param tableID 桌编号
     * @return Integer
     */
    public Integer getOrderingID(Integer tableID){
        Integer orderID = adminAcceptService.getOrderingID(tableID);
        return orderID;
    }

    /**
     * 获取某餐厅全部未处理订单信息
     * @param restID 餐厅编号
     * @return Response
     */
    @GetMapping("/getPendingList")
    public Result getPendingList(@RequestParam String restID){
        List<Order> pendingOrderList = adminAcceptService.getPendingList(restID);
        return Result.success(pendingOrderList);
    }

    /**
     * 查看某个未接单订单时获取该订单信息
     * @param orderID 订单编号
     * @return Response
     */
    @GetMapping("/getPendingOrder")
    public Result getPendingOrder(@RequestParam Integer orderID){
        Order pendingOrder = adminAcceptService.getPendingOrder(orderID);
        return Result.success(pendingOrder);
    }

    /**
     * 查看某个未接单订单时获取该订单的所有订单项
     * @param orderID 订单编号
     * @return Response
     */
    @GetMapping("/getPendingItem")
    public Result getPendingItem(@RequestParam Integer orderID){
        List<OrderItem> itemList = adminAcceptService.getPendingItem(orderID);
        return Result.success(itemList);
    }

    /**
     * 管理员接单
     * @param orderID 订单编号
     * @return Response
     */
    @PostMapping("/acceptOrder")
    public Result acceptOrder(@RequestParam Integer orderID){
        adminAcceptService.acceptOrder(orderID);
        return Result.success();
    }
}
