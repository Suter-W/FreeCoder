package com.freecoder.web.service;

import com.freecoder.web.model.Order;
import com.freecoder.web.model.OrderItem;
import com.freecoder.web.model.Table;

import java.lang.invoke.CallSite;
import java.util.List;
import java.util.Map;

public interface AdminOrderService {
    List<Table> tableList(String restID);

    boolean addTable(Table table);

    boolean editTable(Table table);

    Table getTableInfo(Integer tableID);

    boolean deleteTable(Integer tableID);

    Order getOrderInfo(Integer orderID);

    List<OrderItem> getOrderItem(Integer orderID);

    Integer getTableID(String restID,String tableName,String tableType);

    Integer getOrderingID(Integer tableID);

    boolean orderSettle(Integer orderID);

    boolean tableSettle(Integer tableID);

    boolean addOrderInfo(Order order);

    Integer getNewOrderID(String restID);

    boolean addNewOrderItem(List<Map<String, Object>> items, String restID,Integer orderID);
}
