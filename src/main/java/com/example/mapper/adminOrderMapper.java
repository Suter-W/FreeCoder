package com.example.mapper;

import com.example.pojo.table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface adminOrderMapper {

    @Select("select * from tableInfo where restID = #{restID}")
    List<table> tableList(String restID);
}
