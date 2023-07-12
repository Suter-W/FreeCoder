package com.freecoder.wx.mapper;

import com.freecoder.wx.model.OrderInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OrderInfoRepositoryTest {
    @Autowired
    OrderInfoRepository orderInfoRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Test
    void createOrder(){
//        List<OrderItem> items = orderItemRepository.findAll(1000);
////        List<OrderItem> items = new ArrayList<>();
//        OrderInfo order = new OrderInfo(1000,new Restaurant("0000001"),new TableInfo(1),"dawei", Instant.now(), 3,new BigDecimal(1231), false, (byte)3,"",items);
//        orderInfoRepository.save(order);
        List<OrderInfo> all = orderInfoRepository.findAll();
        System.out.println(all);
    }
}
