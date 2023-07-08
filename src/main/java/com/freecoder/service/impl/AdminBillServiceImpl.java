package com.freecoder.service.impl;

import com.freecoder.mapper.AdminBillMapper;
import com.freecoder.model.Order;
import com.freecoder.model.OrderItem;
import com.freecoder.service.AdminBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
