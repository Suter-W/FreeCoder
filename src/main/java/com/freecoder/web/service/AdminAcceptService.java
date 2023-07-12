package com.freecoder.web.service;

import com.freecoder.web.model.Order;
import com.freecoder.web.model.OrderItem;

import java.util.List;

public interface AdminAcceptService {
    Integer getTableID(String restID,String tableName,String tableType);

    Integer getOrderingID(Integer orderID);

    List<Order> getPendingList(String restID);

    Order getPendingOrder(Integer orderID);

    List<OrderItem> getPendingItem(Integer orderID);

    boolean acceptOrder(Integer orderID);

    void setTableStatus(Integer orderID);
}
