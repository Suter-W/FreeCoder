package com.freecoder.service.impl;

import com.freecoder.mapper.AdminOrderMapper;
import com.freecoder.model.Order;
import com.freecoder.model.OrderItem;
import com.freecoder.model.Table;
import com.freecoder.service.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminOrderServiceImpl implements AdminOrderService {
    @Autowired
    private AdminOrderMapper adminOrderMapper;

    @Override
    public List<Table> tableList(String restID){
        return adminOrderMapper.tableList(restID);
    }

    public boolean addTable(Table table){
        boolean addTableStatus = adminOrderMapper.addTable(table);
        return addTableStatus;
    }

    public boolean editTable(Table table){
        boolean editTableStatus = adminOrderMapper.editTable(table);
        return editTableStatus;
    }

    public Table getTableInfo(Integer tableID){return adminOrderMapper.getTableInfo(tableID);}

    public boolean deleteTable(Integer tableID){
        boolean deleteTableStatus = adminOrderMapper.deleteTable(tableID);
        return deleteTableStatus;
    }

    public Order getOrderInfo(Integer orderID){
        return adminOrderMapper.getOrderInfo(orderID);
    }

    public List<OrderItem> getOrderItem(Integer orderID){return adminOrderMapper.getOrderItem(orderID);}

    public Integer getTableID(String restID,String tableName,String tableType){return adminOrderMapper.getTableID(restID,tableName,tableType);}

    public Integer getOrderingID(Integer tableID){return adminOrderMapper.getOrderingID(tableID);}
}
