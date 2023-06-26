package com.example.service;

import com.example.pojo.Table;

import java.util.List;

public interface adminOrderService {
    List<Table> tableList(String restID);

    void addTable(Table table);
}
