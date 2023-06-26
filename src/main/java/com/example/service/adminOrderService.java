package com.example.service;

import com.example.pojo.table;

import java.util.List;

public interface adminOrderService {
    List<table> tableList(String restID);

    void addTable(table table);
}
