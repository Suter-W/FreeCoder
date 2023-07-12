package com.freecoder.web.service.impl;

import com.freecoder.web.mapper.AdminBillMapper;
import com.freecoder.web.model.Order;
import com.freecoder.web.model.OrderItem;
import com.freecoder.web.model.PageBean;
import com.freecoder.web.service.AdminBillService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @ClassName AdminBillServiceImpl
 * @Description TODO
 * @DATE 2023/7/7 9:04
 */

@Service
public class AdminBillServiceImpl implements AdminBillService {

    @Autowired
    private AdminBillMapper adminBillMapper;

    @Override
    public List<Order> getHistoricalOrders(String restID){
        return adminBillMapper.getHistoricalOrders(restID);
    }

    public List<OrderItem> getHistoricalOrderDetails(String restID,Integer orderID){
        return adminBillMapper.getHistoricalOrderDetails(restID,orderID);
    }

    public PageBean getHistoricalBill(Integer page,String restID, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page,6);
        List<Order> orderList = adminBillMapper.getHistoricalBill(page,restID,begin,end);
        Page<Order> p = (Page<Order>) orderList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    public Order getOrderInfoByid(Integer orderID){return adminBillMapper.getOrderInfoByid(orderID);};

    public List<OrderItem> getOrderItemByid(Integer orderID){return adminBillMapper.getOrderItemByid(orderID);};
}
