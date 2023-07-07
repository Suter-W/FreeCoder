package com.freecoder.service;

import com.freecoder.model.Order;
import com.freecoder.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminBillService {

    List<Order> getHistoricalOrders(String restID);

    List<OrderItem> getHistoricalOrderDetails(String restID, Integer orderID);
}
