package com.freecoder.web.controller;


import com.freecoder.response.MyResult;
import com.freecoder.web.model.Order;
import com.freecoder.web.model.OrderItem;
import com.freecoder.web.model.Table;
import com.freecoder.web.service.AdminOrderService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/web/adminOrder")
@PermitAll
@CrossOrigin
public class AdminOrderController {

    @Autowired
    private AdminOrderService adminOrderService;

    /**
     * @Description 下面两个gettableID与getOrderingID方法用于内部，作用为提取对应的tableID和正在进行的订单ID
     * @Date 11:16 2023/7/1
     * @Param [java.lang.String, java.lang.String, java.lang.String] [restID, tableName, tableType]
     * @return java.lang.Integer
     **/
    public Integer gettableID(String restID,String tableName,String tableType){
        Integer tableID = adminOrderService.getTableID(restID,tableName,tableType);
        return (tableID);
    }

    public Integer getOrderingID(Integer tableID){
        Integer orderID = adminOrderService.getOrderingID(tableID);
        return orderID;
    }

    /**
     * @Description tableList为点餐页面开始罗列桌所用，提取该restID下的所有桌
     * @Date 11:15 2023/7/1
     * @Param [java.lang.String] [restID]
     * @return com.freecoder.response.MyResult
     **/
    @GetMapping("/getTableList")
    public MyResult tableList(@RequestParam String restID){

        List<Table> tableList = adminOrderService.tableList(restID);
        System.out.println(tableList);
        return com.freecoder.response.MyResult.success(tableList);
    }

    /**
     * @Description addTable为添加桌
     * @Date 11:14 2023/7/1
     * @Param [com.freecoder.model.Table] [table]
     * @return com.freecoder.response.MyResult
     **/
    @PostMapping("/addTable")
    public MyResult addTable(@RequestBody Table table){
        adminOrderService.addTable(table);
        return(com.freecoder.response.MyResult.success("success","添加成功")) ;
    }

    /**
     * @Description editTable为编辑桌
     * @Date 11:12 2023/7/1
     * @Param [com.freecoder.model.Table] [table]
     * @return com.freecoder.response.MyResult
     **/
    @PostMapping("/editTable")
    public MyResult editTable(@RequestBody Table table){
        adminOrderService.editTable(table);
        return(com.freecoder.response.MyResult.success("success","编辑成功"));
    }


    /**
     * @Description 通过餐厅ID、桌子ID和桌子的类型对应点单页面的每一个桌子，用于获取tableInfo表的全部内容并进行展示
     * @Date 11:09 2023/7/1
     * @Param [java.lang.Integer] [tableID]
     * @return com.freecoder.response.MyResult
     **/
    @GetMapping("/getTableInfo")
    public MyResult getTableInfo(@RequestParam Integer tableID){
        Table table = adminOrderService.getTableInfo(tableID);
        return(com.freecoder.response.MyResult.success(table));
    }


    /**
     * @Description 对创建的桌子进行删除操作
     * @Date 11:16 2023/7/1
     * @Param [java.lang.Integer] [tableID]
     * @return com.freecoder.response.MyResult
     **/

    @DeleteMapping("/deleteTable")
    public MyResult deleteTable(@RequestParam Integer tableID){
        adminOrderService.deleteTable(tableID);
        return com.freecoder.response.MyResult.success("success","删除成功");
    }


    /**
     * @Description 取出订单信息
     * @Date 11:17 2023/7/1
     * @Param [java.lang.Integer] [tableID]
     * @return com.freecoder.response.MyResult
     **/
    @GetMapping("/getOrderInfo")
    public MyResult getOrderInfo(@RequestParam Integer tableID) throws Exception {
        if (tableID < 0) {
            throw new IllegalArgumentException("Order ID cannot be negative");
        }
        Integer orderID = getOrderingID(tableID);
        Order orderInfo = adminOrderService.getOrderInfo(orderID);
        return com.freecoder.response.MyResult.success(orderInfo);
    }

    /**
     * @Description 取出订单具体项
     * @param tableID
     * @Date 15:18 2023/7/1
     * @Param [java.lang.Integer]
     * @return com.freecoder.response.MyResult
     **/
    @GetMapping("/getOrderItem")
    public MyResult getOrderItem(@RequestParam Integer tableID){
        Integer orderID = getOrderingID(tableID);
        List<OrderItem> orderItem = adminOrderService.getOrderItem(orderID);
        return MyResult.success(orderItem);
    }

    /**
     * @Description 将订单置为结束
     * @param tableID 桌号
     * @return MyResult
     */
    @GetMapping("/orderSettle")
    public MyResult orderSettle(@RequestParam Integer tableID){
        Integer orderID = getOrderingID(tableID);
        adminOrderService.orderSettle(orderID);
        return com.freecoder.response.MyResult.success("success","操作完成");
    }

    /**
     * @Description 将桌置为空闲
     * @param tableID 桌号
     * @return
     */
    @GetMapping("/tableSettle")
    public MyResult tableSettle(@RequestParam Integer tableID){
        adminOrderService.tableSettle(tableID);
        return com.freecoder.response.MyResult.success("success","操作完成");
    }
}
