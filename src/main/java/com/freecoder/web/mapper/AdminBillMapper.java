package com.freecoder.web.mapper;

import com.freecoder.web.model.Order;
import com.freecoder.web.model.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface AdminBillMapper {

    @Select("select * from order_info where restID = #{restID} and orderStatus = 0")
    List<Order> getHistoricalOrders(String restID);

    @Select("select * from order_item where restID = #{restID} and orderID = #{orderID}")
    List<OrderItem> getHistoricalOrderDetails(String restID, Integer orderID);

    List<Order> getHistoricalBill(Integer page, String restID,LocalDate begin, LocalDate end);
}
