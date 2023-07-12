package com.freecoder.service;

import com.freecoder.model.Order;
import com.freecoder.model.OrderItem;
import com.freecoder.model.PageBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface AdminBillService {

    List<Order> getHistoricalOrders(String restID);

    List<OrderItem> getHistoricalOrderDetails(String restID, Integer orderID);

    PageBean getHistoricalBill(Integer page, String restID,LocalDate begin, LocalDate end);

    Order getOrderInfoByid(Integer orderID);

    List<OrderItem> getOrderItemByid(Integer orderID);
}
