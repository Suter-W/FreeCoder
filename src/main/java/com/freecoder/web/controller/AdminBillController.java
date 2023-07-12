package com.freecoder.web.controller;

import com.freecoder.response.MyResult;
import com.freecoder.web.service.AdminBillService;
import com.freecoder.web.model.Order;
import com.freecoder.web.model.OrderItem;
import com.freecoder.web.model.PageBean;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
     * @return com.freecoder.response.MyResult
     **/
    @GetMapping("/getHistoricalOrders")
    public MyResult getHistoricalOrders(@RequestParam String restID){
        List<Order> orderList = adminBillService.getHistoricalOrders(restID);
        return MyResult.success(orderList);
    }

    /**
     * @Description 当前端点击对应账单的查看详情按钮时，通过其订单号访问订单项数据库表，查询数据
     * @param restID 餐厅号
     * @param orderID  订单号
     * @Date 9:35 2023/7/7
     *
     * @return com.freecoder.response.MyResult
     **/
    @GetMapping("/getHistoricalOrderDetails")
    public MyResult getHistoricalOrderDetails(@RequestParam String restID, @RequestParam Integer orderID){
        List<OrderItem> orderItemList = adminBillService.getHistoricalOrderDetails(restID,orderID);
        return MyResult.success(orderItemList);
    }

    /**
     * @Description 前端账单界面分页条件查询实现
     * @param page 页码
     * @param begin 查询开始时间
     * @param end   查询结束时间
     * @return  pageBean
     * @Date 9:35 2023/7/8
     */
    @GetMapping("/getHistoricalBill")
    public MyResult getHistoricalBill(@RequestParam(defaultValue = "1")Integer page,
                                      @RequestParam String restID,
                                      @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDate begin,
                                      @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDate end) {
        PageBean pageBean = adminBillService.getHistoricalBill(page,restID, begin, end);
        return com.freecoder.response.MyResult.success(pageBean);
    }
    @GetMapping("/getOrderInfoByid")
    public MyResult getOrderInfoByid(@RequestParam Integer orderID){
        Order order = adminBillService.getOrderInfoByid(orderID);
        return com.freecoder.response.MyResult.success(order);
    }
    @GetMapping("/getOrderItemByid")
    public MyResult getOrderItemByid(@RequestParam Integer orderID){
        List<OrderItem> itemList = adminBillService.getOrderItemByid(orderID);
        return MyResult.success(itemList);
    }
}
