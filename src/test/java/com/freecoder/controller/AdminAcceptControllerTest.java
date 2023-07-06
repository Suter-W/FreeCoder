package com.freecoder.controller;

import com.freecoder.service.AdminAcceptService;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class AdminAcceptControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    AdminAcceptService adminAcceptService;
    /**
     * @Description 测试获取某餐厅全部未处理订单信息的功能
     * restID 餐厅号
     * @Date 15:06 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    void getPendingList() throws Exception {
//
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.get("/adminAccept/getPendingList")
//                        .param("restID","0000001")
//                        .header("Content-Type", "application/json")
//                        .header("Authorization", "Bearer " + token))
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn().getResponse().getContentAsString();
//        DocumentContext jsonRes = JsonPath.parse(response);
//        System.out.println(jsonRes.jsonString());
//        Assertions.assertEquals((int)jsonRes.read("$.code"),1);
//        Assertions.assertEquals(jsonRes.read("$.msg"),"success");
//    }

    @Test
    void getPendingList() throws Exception {
        assertNotNull(adminAcceptService.getPendingList("0000001"));
    }

    /**
     * @Description 测试查看某个未接单订单时获取该订单信息的功能
     * orderID 订单ID
     * @Date 15:06 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    void getPendingOrder() throws Exception {
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.get("/adminAccept/getPendingOrder")
//                        .param("orderID","2")
//                        .header("Content-Type", "application/json")
//                        .header("Authorization", "Bearer " + token))
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn().getResponse().getContentAsString();
//        DocumentContext jsonRes = JsonPath.parse(response);
//        System.out.println(jsonRes.jsonString());
//        Assertions.assertEquals((int)jsonRes.read("$.code"),1);
//        Assertions.assertEquals(jsonRes.read("$.msg"),"success");
//    }

    @Test
    void getPendingOrder() throws Exception {
        assertNotNull(adminAcceptService.getPendingOrder(2));
    }

    /**
     * @Description 测试查看某个未接单订单时获取该订单的所有订单项的功能
     * orderID 订单ID
     * @Date 15:07 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    void getPendingItem() throws Exception {
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.get("/adminAccept/getPendingItem")
//                        .param("orderID","1")
//                        .header("Content-Type", "application/json")
//                        .header("Authorization", "Bearer " + token))
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn().getResponse().getContentAsString();
//        DocumentContext jsonRes = JsonPath.parse(response);
//        System.out.println(jsonRes.jsonString());
//        Assertions.assertEquals((int)jsonRes.read("$.code"),1);
//        Assertions.assertEquals(jsonRes.read("$.msg"),"success");
//    }

    @Test
    void getPendingItem() throws Exception {
        assertNotNull(adminAcceptService.getPendingItem(1));
    }

    /**
     * @Description 测试管理员接单的功能
     * orderID 订单ID
     * @Date 15:07 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    @Transactional
//    void acceptOrder() throws Exception {
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.post("/adminAccept/acceptOrder")
//                        .param("orderID","1")
//                        .header("Content-Type", "application/json")
//                        .header("Authorization", "Bearer " + token))
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn().getResponse().getContentAsString();
//        DocumentContext jsonRes = JsonPath.parse(response);
//        System.out.println(jsonRes.jsonString());
//        Assertions.assertEquals((int)jsonRes.read("$.code"),1);
//        Assertions.assertEquals(jsonRes.read("$.msg"),"success");
//    }

    @Test
    @Transactional
    void acceptOrder() throws Exception {
        assertTrue(adminAcceptService.acceptOrder(1));
    }
}