package com.freecoder.web.controller;

import com.freecoder.web.model.Order;
import com.freecoder.web.model.OrderItem;
import com.freecoder.web.model.Result;
import com.freecoder.web.service.AdminBillService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName AdminBillController
 * @Description TODO
 * @DATE 2023/7/7 8:55
 */

@RestController
@PermitAll
@CrossOrigin
@RequestMapping("/web/adminBill")
public class AdminBillController {

    @Autowired
    private AdminBillService adminBillService;


    /**
     * @Description 根据餐厅号获取对应餐厅的所有已完成的历史订单
     * @param restID  餐厅号
     * @Date 9:11 2023/7/7
     *
     * @return com.freecoder.web.model.Response
     **/
    @GetMapping("/getHistoricalOrders")
    public Result getHistoricalOrders(@RequestParam String restID){
        List<Order> orderList = adminBillService.getHistoricalOrders(restID);
        return Result.success(orderList);
    }

    /**
     * @Description 当前端点击对应账单的查看详情按钮时，通过其订单号访问订单项数据库表，查询数据
     * @param restID 餐厅号
     * @param orderID  订单号
     * @Date 9:35 2023/7/7
     *
     * @return com.freecoder.web.model.Response
     **/
    @GetMapping("/getHistoricalOrderDetails")
    public Result getHistoricalOrderDetails(@RequestParam String restID,@RequestParam Integer orderID){
        List<OrderItem> orderItemList = adminBillService.getHistoricalOrderDetails(restID,orderID);
        return Result.success(orderItemList);
    }
}
