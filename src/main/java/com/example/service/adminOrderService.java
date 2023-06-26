package com.example.service;

import com.example.pojo.Table;

import java.util.List;

public interface adminOrderService {
    List<Table> tableList(String restID);

    void addTable(Table table);

    void editTable(String tableID,String tableType,Integer tableLimit,Integer id);

    Table getTableInfo(String restID,String tableID,String tableType);

    void deleteTable(Integer ID);
}
