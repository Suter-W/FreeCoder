package com.example.service;

import com.example.pojo.Order;
import com.example.pojo.OrderItem;
import com.example.pojo.Table;

import java.util.List;

public interface adminOrderService {
    List<Table> tableList(String restID);

    void addTable(Table table);

    void editTable(String tableName,String tableType,Integer tableLimit,Integer tableID);

    Table getTableInfo(String restID,String tableName,String tableType);

    void deleteTable(Integer tableID);

    Integer getTableID(String restID,String tableName,String tableType);

    Integer getOrderingID(Integer orderID);

    Order getOrderInfo(Integer orderID);

    List<OrderItem> getOrderItem(Integer orderID);
}
