package com.freecoder.web.service;

import com.freecoder.web.model.Order;
import com.freecoder.web.model.OrderItem;
import com.freecoder.web.model.Tables;

import java.util.List;

public interface AdminOrderService {
    List<Tables> tableList(String restID);

    boolean addTable(Tables tables);

    boolean editTable(Tables tables);

    Tables getTableInfo(Integer tableID);

    boolean deleteTable(Integer tableID);

    Order getOrderInfo(Integer orderID);

    List<OrderItem> getOrderItem(Integer orderID);

    Integer getTableID(String restID,String tableName,String tableType);

    Integer getOrderingID(Integer orderID);
}
