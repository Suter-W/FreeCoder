package com.freecoder.web.mapper;

import com.freecoder.web.model.Order;
import com.freecoder.web.model.OrderItem;
import com.freecoder.web.model.Tables;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminOrderMapper {

    @Select("select * from table_info where restID = #{restID}")
    List<Tables> tableList(String restID);

    boolean addTable(Tables tables);

    boolean editTable(Tables tables);

    @Select("select * from table_info where tableID = #{tableID}")
    Tables getTableInfo(Integer tableID);

    boolean deleteTable(Integer tableID);

    @Select("select * from order_info where orderID = #{orderID}")
    Order getOrderInfo(Integer orderID);

    @Select("select * from order_item where orderID = #{orderID}")
    List<OrderItem> getOrderItem(Integer orderID);

    @Select("select tableID from table_info where restID = #{restID} and tableName = #{tableName} and tableType = #{tableType}")
    Integer getTableID(String restID,String tableName,String tableType);

    @Select("select orderID from order_info where tableID = #{tableID} and orderStatus != 0")
    Integer getOrderingID(Integer tableID);
}
