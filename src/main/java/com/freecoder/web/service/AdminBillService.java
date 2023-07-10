package com.freecoder.web.service;

import com.freecoder.web.model.Order;
import com.freecoder.web.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminBillService {

    List<Order> getHistoricalOrders(String restID);

    List<OrderItem> getHistoricalOrderDetails(String restID, Integer orderID);
}
