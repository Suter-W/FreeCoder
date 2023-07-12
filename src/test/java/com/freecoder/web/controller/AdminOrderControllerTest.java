package com.freecoder.web.controller;

import com.freecoder.web.model.Table;
import com.freecoder.web.service.AdminOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class AdminOrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    AdminOrderService adminOrderService;

    /**
     * @Description 测试tableList为点餐页面开始罗列桌所用，提取该restID下的所有桌
     * restID 餐厅号
     * @Date 16:07 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    void tableList() throws Exception {
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.get("/adminOrder/getTableList")
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
    void tableList() throws Exception {
        assertNotNull(adminOrderService.tableList("0000001"));
    }

    /**
     * @Description 测试添加桌的功能
     * 一个请求体 包括restID 餐厅号  tableName  桌名  tableLimit  单桌人数限制  tableType  桌子位置
     * @Date 16:42 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    @Transactional
//    void addTable() throws Exception {
//        String responseBody = "{\"restID\": \"0000002\", \"tableName\": \"08\", \"tableLimit\": 4, \"tableType\": \"大厅\"}";
//
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.post("/adminOrder/addTable")
//                        .content(responseBody)
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
    void addTable() throws Exception {
        Table table = new Table();
        table.setRestID("0000002");
        table.setTableName("08");
        table.setTableLimit(4);
        table.setTableType("大厅");

        assertTrue(adminOrderService.addTable(table));
    }

    /**
     * @Description 测试编辑桌的功能
     * 一个请求体  tableName  桌名  tableType  桌子位置  tableLimit  单桌人数限制  tableID  桌号
     * @Date 16:43 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    @Transactional
//    void editTable() throws Exception {
//        String responseBody = "{\"tableName\": \"20\", \"tableType\": \"大厅\", \"tableLimit\": \"6\", \"tableID\": 5}";
//
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.post("/adminOrder/editTable")
//                        .content(responseBody)
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
    void editTable() throws Exception {
        Table table = new Table();
        table.setTableID(20);
        table.setTableName("20");
        table.setTableLimit(6);
        table.setTableType("大厅");

        assertTrue(adminOrderService.editTable(table));
    }
    /**
     * @Description 测试通过餐厅ID、桌子ID和桌子的类型对应点单页面的每一个桌子，用于获取tableInfo表的全部内容并进行展示的功能
     * tableID 桌号  table_info的主键
     * @Date 16:45 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    void getTableInfo() throws Exception {
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.get("/adminOrder/getTableInfo")
//                        .param("tableID","3")
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
    void getTableInfo() throws Exception {
        assertNotNull(adminOrderService.getTableInfo(20));
    }

    /**
     * @Description 测试对创建的桌子进行删除操作的功能
     * tableID 桌号  table_info的主键
     * @Date 16:46 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    @Transactional
//    void deleteTable() throws Exception {
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.delete("/adminOrder/deleteTable")
//                        .param("tableID","13")
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
    void deleteTable() throws Exception {
        assertTrue(adminOrderService.deleteTable(13));
    }

    /**
     * @Description 测试取出订单信息的功能
     * tableID 桌号  table_info的主键  该方法中用于调用getOrderingID方法获取order_info表中的orderID
     * @Date 16:47 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    void getOrderInfo() throws Exception {
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.get("/adminOrder/getOrderInfo")
//                        .param("tableID","1")
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

    /**
     * @Description 测试取出订单信息的功能
     * tableID 桌号  table_info的主键  该方法中用于调用getOrderingID方法获取order_info表中的orderID
     * @Date 16:47 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
    @Test
    void getOrderInfo() throws Exception {
        assertNotNull(adminOrderService.getOrderInfo(20));
    }

    /**
     * @Description 测试取出订单具体项的功能
     * tableID 桌号  table_info的主键  该方法中用于调用getOrderingID方法获取order_info表中的orderID
     * @Date 16:47 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    void getOrderItem() throws Exception {
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.get("/adminOrder/getOrderItem")
//                        .param("tableID","1")
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
    void getOrderItem() throws Exception {
        assertNotNull(adminOrderService.getOrderItem(1));
    }
}