package com.freecoder.service;

import com.freecoder.model.Order;
import com.freecoder.model.OrderItem;

import java.util.List;

public interface AdminAcceptService {
    Integer getTableID(String restID,String tableName,String tableType);

    Integer getOrderingID(Integer orderID);

    List<Order> getPendingList(String restID);

    Order getPendingOrder(Integer orderID);

    List<OrderItem> getPendingItem(Integer orderID);

    boolean acceptOrder(Integer orderID);
}
