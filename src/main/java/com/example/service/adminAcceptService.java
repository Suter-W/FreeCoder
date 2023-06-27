package com.example.service;

import com.example.pojo.Order;
import com.example.pojo.OrderItem;

import java.util.List;

public interface adminAcceptService {
    Integer getTableID(String restID,String tableName,String tableType);

    Integer getOrderingID(Integer orderID);

    List<Order> getPendingList(String restID);

    Order getPendingOrder(Integer orderID);

    List<OrderItem> getPendingItem(Integer orderID);

    void acceptOrder(Integer orderID);
}
