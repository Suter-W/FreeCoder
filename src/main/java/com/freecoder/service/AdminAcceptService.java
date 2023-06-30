package com.freecoder.service;

import com.freecoder.pojo.Order;
import com.freecoder.pojo.OrderItem;

import java.util.List;

public interface AdminAcceptService {
    Integer getTableID(String restID,String tableName,String tableType);

    Integer getOrderingID(Integer orderID);

    List<Order> getPendingList(String restID);

    Order getPendingOrder(Integer orderID);

    List<OrderItem> getPendingItem(Integer orderID);

    void acceptOrder(Integer orderID);
}
