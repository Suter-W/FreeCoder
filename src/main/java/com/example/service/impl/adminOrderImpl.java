package com.example.service.impl;

import com.example.mapper.adminOrderMapper;
import com.example.pojo.table;
import com.example.service.adminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class adminOrderImpl implements adminOrderService {
    @Autowired
    private adminOrderMapper adminOrderMapper;

    @Override
    public List<table> tableList(String restID){
        return adminOrderMapper.tableList(restID);
    }

    @Override
    public void addTable(table table) {
        adminOrderMapper.addTable(table);
    }
}
