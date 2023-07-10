package com.freecoder.service;

import com.freecoder.model.Order;
import com.freecoder.model.OrderItem;
import com.freecoder.model.Table;

import java.util.List;

public interface AdminOrderService {
    List<Table> tableList(String restID);

    boolean addTable(Table table);

    boolean editTable(Table table);

    Table getTableInfo(Integer tableID);

    boolean deleteTable(Integer tableID);

    Order getOrderInfo(Integer orderID);

    List<OrderItem> getOrderItem(Integer orderID);

    Integer getTableID(String restID,String tableName,String tableType);

    Integer getOrderingID(Integer orderID);

    void orderSettle(Integer orderID);

    void tableSettle(Integer tableID);
}
