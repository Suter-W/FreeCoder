package com.freecoder.web.controller;

import com.freecoder.web.model.Dish;
import com.freecoder.web.service.AdminDishService;
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
class AdminDishControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    AdminDishService adminDishService;
    /**
     * @Description 测试获取菜品信息页面的全部数据的功能
     * restID 餐厅号  dishName 菜品名称（该数据可以为空，表示全部查找）
     * @Date 15:20 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    void getDishInfo() throws Exception {
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.get("/adminDish/getDishInfo")
//                        .param("restID","0000001")
//                        .param("dishName","")
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
    void getDishInfo() throws Exception {
        assertNotNull(adminDishService.getDishInfo("0000001",""));
    }

    /**
     * @Description 测试更改dish_info表，即更新菜品信息功能
     * 一个请求体body 包括restID 餐厅号  dishCategory 菜品分类  dishPrice  菜品价格  dishDescription 菜品描述
     * dishName 菜品名称  dishImage  菜品图  VipPrice  会员价格  dcID  菜品分类的ID，外键
     * @Date 15:38 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    @Transactional
//    void addDishInfo() throws Exception {
//        String responseBody = "{\"restID\": \"0000001\", \"dishCategory\": \"面食\", \"dishPrice\": \"9\", \"dishDescription\": \"己行通最查三解形月。\", \"dishName\": \"冷面\", \"dishImage\": \"http://dummyimage.com/120x240\", \"VipPrice\": \"30\",\"dcID\": 6}";
//
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.post("/adminDish/addDishInfo")
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
    void addDishInfo() throws Exception {
        Dish dish = new Dish();
        dish.setRestID("0000001");
        dish.setDishCategory("面食");
        dish.setDishPrice("9");
        dish.setDishDescription("己行通最查三解形月");
        dish.setDishName("冷面");
        dish.setDishImage("http://dummyimage.com/120x240");
        dish.setVipPrice("30");
        dish.setDcID(6);
        assertTrue(adminDishService.addDishInfo(dish));

    }

    /**
     * @Description 测试更改dish_info表，即更新菜品信息功能
     * 一个请求体body 可以修改包括dish_info表中的参数
     * @Date 15:54 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    @Transactional
//    void updateDishInfo() throws Exception {
//        //该responseBody的内容可以修改，update采用的是动态SQL，可以修改同一行中任意个参数
//        String responseBody = "{\"dishImage\": \"http://dummyimage.com/468x60\", \"dishDescription\": \"好喝\", \"dishID\": 15}";
//
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.post("/adminDish/updateDishInfo")
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
    void updateDishInfo() throws Exception {
        Dish dish = new Dish();
        dish.setDishImage("http://dummyimage.com/120x240");
        dish.setDishDescription("好喝");
        dish.setDishID(6);

        assertTrue(adminDishService.updateDishInfo(dish));
    }

    /**
     * @Description 测试删除dish_info表中内容，即删除菜品功能
     * dishID  菜品ID dish_info的主键
     * @Date 15:59 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    @Transactional
//    void deleteDishInfo() throws Exception {
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.delete("/adminDish/deleteDishInfo")
//                        .param("dishID","13")
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
    void deleteDishInfo() throws Exception {
        assertTrue(adminDishService.deleteDishInfo(13));
    }
}