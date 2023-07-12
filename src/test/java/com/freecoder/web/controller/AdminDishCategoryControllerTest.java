package com.freecoder.web.controller;

import com.freecoder.web.model.DishCategory;
import com.freecoder.web.service.AdminDishCategoryService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AdminDishCategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    AdminDishCategoryService adminDishCategoryService;
    /**
     * @Description 测试菜品分类的查询方法
     * restID 餐厅号  page 分页查询的页码
     * @Date 20:36 2023/7/5
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    public void getDishCategoryInfoTest() throws Exception {
//        int page = 2;
//
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.get("/adminDishCategory/getDishCategoryInfo")
//                        .param("restID","0000001")
//                        .param("page",String.valueOf(page))
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
    public void getDishCategoryInfoTest() throws Exception {
        assertNotNull(adminDishCategoryService.getDishCategoryInfo("0000001"));
    }

    /**
     * @Description 测试菜品分类模块的增加菜品分类功能
     * responseBody 存储restID 餐厅号  dcName 菜品分类名  dcOrder 菜品分类顺序  dishNumber 该分类下对应菜品的总数
     * @Date 11:07 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    @Transactional //用于事务管理和回滚操作，将数据库的修改取消
//    public void addDishCategoryTest() throws Exception {
//        String responseBody = "{\"restID\": \"0000001\", \"dcName\": \"湘菜\", \"dcOrder\": 7, \"dishNumber\": 0}";
//
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.post("/adminDishCategory/addDishCategory")
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
    @Transactional //用于事务管理和回滚操作，将数据库的修改取消
    public void addDishCategoryTest() throws Exception {
        DishCategory dishCategory = new DishCategory();
        dishCategory.setRestID("0000001");
        dishCategory.setDcName("湘菜");
        dishCategory.setDcOrder(7);
        dishCategory.setDishNumber(0);

        assertTrue(adminDishCategoryService.addDishCategory(dishCategory));
    }

    /**
     * @Description 测试菜品分类模块的删除菜品分类功能
     * 一个Query参数 dcID 餐品分类表的主键
     * @Date 11:10 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    @Transactional
//    public void deleteDishCategoryTest() throws Exception{
//
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.delete("/adminDishCategory/deleteDishCategory")
//                        .param("dcID","10")
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
    public void deleteDishCategoryTest() throws Exception{
        assertTrue(adminDishCategoryService.deleteDishCategory(9));
    }

    /**
     * @Description 测试菜品分类模块的更新菜品顺序的功能
     * 一个Query参数 restID 餐厅号 一个请求体 存储前端返回的主键ID的数组用于重新排序
     * @Date 11:13 2023/7/6
     * token用于通过过滤器的拦截，从而正常使用
     * @return void
     **/
//    @Test
//    @Transactional
//    public void sortDishCategoryTest() throws Exception{
//
//        String requestBody = "[5, 3, 8, 9, 1, 2, 6, 7, 4]";
//
//        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
//        String response = mockMvc.perform(MockMvcRequestBuilders.post("/adminDishCategory/sortDishCategory")
//                        .param("restID","0000001")
//                        .content(requestBody)
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
    public void sortDishCategoryTest() throws Exception{
        List<Integer> IDPresentList = Arrays.asList(5, 3, 8, 9, 1, 2, 6, 7, 4);
        assertTrue(adminDishCategoryService.sortDishCategory("0000001",IDPresentList));
    }
}