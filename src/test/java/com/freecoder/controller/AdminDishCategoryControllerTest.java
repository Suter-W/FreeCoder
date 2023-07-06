package com.freecoder.controller;

import com.freecoder.service.AdminDishCategoryService;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AdminDishCategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminDishCategoryService adminDishCategoryService;

    /**
     * @Description 测试菜品分类的查询方法
     * @param   restID 餐厅号  page 分页查询的页码
     * @Date 20:36 2023/7/5
     * @Param []
     * @return void
     **/
    @Test
    public void getDishCategoryInfoTest() throws Exception {
        int page = 2;

        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
        String response = mockMvc.perform(MockMvcRequestBuilders.post("/adminDishCategory/getDishCategoryInfo")
                        .param("restID","0000001")
                        .param("page",String.valueOf(page))
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer " + token))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        DocumentContext jsonRes = JsonPath.parse(response);

        Assertions.assertEquals((int)jsonRes.read("$.code"),1);
        Assertions.assertEquals(jsonRes.read("$.msg"),"success");
    }
}