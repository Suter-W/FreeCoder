package com.freecoder.web.mapper;


import com.freecoder.web.model.Order;
import com.freecoder.web.model.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminAcceptMapper {

    @Select("select tableID from table_info where restID = #{restID} and tableName = #{tableName} and tableType = #{tableType}")
    Integer getTableID(String restID,String tableName,String tableType);

    @Select("select orderID from order_info where tableID = #{tableID} and orderStatus != 0")
    Integer getOrderingID(Integer tableID);

    @Select("select * from order_info where restID = #{restID} and orderStatus = 3")
    List<Order> getPendingList(String restID);

    @Select("select * from order_info where orderID=#{orderID}")
    Order getPendingOrder(Integer orderID);

    @Select("select * from order_item where orderID = #{orderID}")
    List<OrderItem> getPendingItem(Integer orderID);

    @Update("update order_info set orderStatus = 2 where orderID = #{orderID}")
    boolean acceptOrder(Integer orderID);

    @Update("update table_info t1 join order_info t2 ON t1.tableID = t2.tableID set t1.tableStatus = 1,t1.tableUse = t2.orderUse where t2.orderID = #{orderID} ")
    void setTableStatus(Integer orderID);
}
