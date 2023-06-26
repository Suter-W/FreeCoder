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

    void deleteTable(String restID);
}
