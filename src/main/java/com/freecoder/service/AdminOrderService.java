package com.freecoder.service;

import com.freecoder.pojo.Order;
import com.freecoder.pojo.OrderItem;
import com.freecoder.pojo.Table;

import java.util.List;

public interface AdminOrderService {
    List<Table> tableList(String restID);

    void addTable(Table table);

    void editTable(Table table);

    Table getTableInfo(Integer tableID);

    void deleteTable(Integer tableID);

    Integer getTableID(String restID,String tableName,String tableType);

    Integer getOrderingID(Integer orderID);

    Order getOrderInfo(Integer orderID);

    List<OrderItem> getOrderItem(Integer orderID);
}
