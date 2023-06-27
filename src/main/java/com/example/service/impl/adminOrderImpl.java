package com.example.service.impl;

import com.example.mapper.adminOrderMapper;
import com.example.pojo.Order;
import com.example.pojo.OrderItem;
import com.example.pojo.Table;
import com.example.service.adminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminOrderImpl implements adminOrderService {
    @Autowired
    private adminOrderMapper adminOrderMapper;

    @Override
    public List<Table> tableList(String restID){
        return adminOrderMapper.tableList(restID);
    }

    public void addTable(Table table) {adminOrderMapper.addTable(table);}

    public void editTable(String tableName,String tableType,Integer tableLimit,Integer tableID){adminOrderMapper.editTable(tableName,tableType,tableLimit,tableID);}

    public Table getTableInfo(String restID,String tableName,String tableType){return adminOrderMapper.getTableInfo(restID,tableName,tableType);}

    public void deleteTable(Integer tableID){adminOrderMapper.deleteTable(tableID);}

    public Integer getTableID(String restID,String tableName,String tableType){return adminOrderMapper.getTableID(restID,tableName,tableType);}

    public Integer getOrderingID(Integer tableID){return adminOrderMapper.getOrderingID(tableID);}

    public Order getOrderInfo(Integer orderID){return adminOrderMapper.getOrderInfo(orderID);}

    public List<OrderItem> getOrderItem(Integer orderID){return adminOrderMapper.getOrderItem(orderID);}
}
