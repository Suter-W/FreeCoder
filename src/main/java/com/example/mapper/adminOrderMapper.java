package com.example.mapper;

import com.example.pojo.Order;
import com.example.pojo.OrderItem;
import com.example.pojo.Table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface adminOrderMapper {

    @Select("select * from table_info where restID = #{restID}")
    List<Table> tableList(String restID);

    void addTable(Table table);

    void editTable(Table table);

    @Select("select * from table_info where tableID = #{tableID}")
    Table getTableInfo(Integer tableID);

    void deleteTable(Integer tableID);

    @Select("select tableID from table_info where restID = #{restID} and tableName = #{tableName} and tableType = #{tableType}")
    Integer getTableID(String restID,String tableName,String tableType);

    @Select("select orderID from order_info where tableID = #{tableID} and orderStatus != 0")
    Integer getOrderingID(Integer tableID);
    @Select("select * from order_info where orderID = #{orderID}")
    Order getOrderInfo(Integer orderID);

    @Select("select * from order_item where orderID = #{orderID}")
    List<OrderItem> getOrderItem(Integer orderID);
}
