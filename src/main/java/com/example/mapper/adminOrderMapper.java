package com.example.mapper;

import com.example.pojo.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface adminOrderMapper {

    @Select("select * from tableInfo where restID = #{restID}")
    List<Table> tableList(String restID);

    void addTable(Table table);

    void editTable(String tableID,String tableType,Integer tableLimit,Integer id);

    @Select("select * from tableinfo where restID = #{restID} and tableID = #{tableID} and tableType = #{tableType}")
    Table getTableInfo(String restID,String tableID,String tableType);

    void deleteTable(Integer ID);
}
