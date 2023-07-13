package com.freecoder.web.mapper;

import com.freecoder.web.model.Order;
import com.freecoder.web.model.OrderItem;
import com.freecoder.web.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminOrderMapper {

    @Select("select * from table_info where restID = #{restID}")
    List<Table> tableList(String restID);

    boolean addTable(Table table);

    boolean editTable(Table table);

    @Select("select * from table_info where tableID = #{tableID}")
    Table getTableInfo(Integer tableID);

    boolean deleteTable(Integer tableID);

    @Select("select * from order_info where orderID = #{orderID}")
    Order getOrderInfo(Integer orderID);

    @Select("select * from order_item where orderID = #{orderID}")
    List<OrderItem> getOrderItem(Integer orderID);

    @Select("select tableID from table_info where restID = #{restID} and tableName = #{tableName} and tableType = #{tableType}")
    Integer getTableID(String restID,String tableName,String tableType);

    @Select("select orderID from order_info where tableID = #{tableID} and orderStatus != 0")
    Integer getOrderingID(Integer tableID);

    @Update("update order_info set orderStatus = 0 where orderID = #{orderID}")
    boolean orderSettle(Integer orderID);

    @Update("update table_info set tableStatus = 0,tableUse = 0 where tableID = #{tableID}")
    boolean tableSettle(Integer tableID);

    boolean addOrderInfo(Order order);

    @Select("select orderID from order_info where restID = #{restID} order by orderID DESC LIMIT 1")
    Integer getNewOrderID(String restID);


    boolean addNewOrderItem(List<Map<String, Object>> items,String restID,Integer orderID);
}
