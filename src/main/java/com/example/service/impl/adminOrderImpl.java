package com.example.service.impl;

import com.example.mapper.adminOrderMapper;
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

    public void editTable(String tableID,String tableType,Integer tableLimit,Integer id){adminOrderMapper.editTable(tableID,tableType,tableLimit,id);}

    public Table getTableInfo(String restID,String tableID,String tableType){return adminOrderMapper.getTableInfo(restID,tableID,tableType);}
}
