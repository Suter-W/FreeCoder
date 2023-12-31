package com.freecoder.web.controller;


import com.freecoder.response.MyResult;
import com.freecoder.web.model.Order;
import com.freecoder.web.model.OrderItem;
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
    public Integer getTableID(String restID,String tableName,String tableType){
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
     * @return MyResult
     */
    @GetMapping("/getPendingList")
    public MyResult getPendingList(@RequestParam String restID){
        List<Order> pendingOrderList = adminAcceptService.getPendingList(restID);
        return com.freecoder.response.MyResult.success(pendingOrderList);
    }

    /**
     * 查看某个未接单订单时获取该订单信息
     * @param orderID 订单编号
     * @return MyResult
     */
    @GetMapping("/getPendingOrder")
    public MyResult getPendingOrder(@RequestParam Integer orderID){
        Order pendingOrder = adminAcceptService.getPendingOrder(orderID);
        return com.freecoder.response.MyResult.success(pendingOrder);
    }

    /**
     * 查看某个未接单订单时获取该订单的所有订单项
     * @param orderID 订单编号
     * @return MyResult
     */
    @GetMapping("/getPendingItem")
    public MyResult getPendingItem(@RequestParam Integer orderID){
        List<OrderItem> itemList = adminAcceptService.getPendingItem(orderID);
        return com.freecoder.response.MyResult.success(itemList);
    }

    /**
     * 管理员接单
     * @param orderID 订单编号
     * @return MyResult
     */
    @GetMapping("/acceptOrder")
    public MyResult acceptOrder(@RequestParam Integer orderID){
        adminAcceptService.acceptOrder(orderID);
        return com.freecoder.response.MyResult.success("success");
    }

    /**
     * 接单后将桌置为占用
     * @param orderID 订单编号
     * @return MyResult
     */
    @GetMapping("/setTableStatus")
    public MyResult setTableStatus(@RequestParam Integer orderID){
        adminAcceptService.setTableStatus(orderID);
        return MyResult.success("success","操作成功");
    }
}
