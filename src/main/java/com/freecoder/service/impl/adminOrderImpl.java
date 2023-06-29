package com.freecoder.service.impl;

import com.freecoder.mapper.adminOrderMapper;
import com.freecoder.pojo.Order;
import com.freecoder.pojo.OrderItem;
import com.freecoder.pojo.Table;
import com.freecoder.service.adminOrderService;
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

    public void editTable(Table table){adminOrderMapper.editTable(table);}

    public Table getTableInfo(Integer tableID){return adminOrderMapper.getTableInfo(tableID);}

    public void deleteTable(Integer tableID){adminOrderMapper.deleteTable(tableID);}

    public Integer getTableID(String restID,String tableName,String tableType){return adminOrderMapper.getTableID(restID,tableName,tableType);}

    public Integer getOrderingID(Integer tableID){return adminOrderMapper.getOrderingID(tableID);}

    public Order getOrderInfo(Integer orderID){return adminOrderMapper.getOrderInfo(orderID);}

    public List<OrderItem> getOrderItem(Integer orderID){return adminOrderMapper.getOrderItem(orderID);}
}
