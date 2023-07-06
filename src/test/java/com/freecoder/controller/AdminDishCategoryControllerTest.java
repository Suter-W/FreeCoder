package com.freecoder.controller;

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

@SpringBootTest
@AutoConfigureMockMvc
public class AdminDishCategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * @Description 还未完成的测试
     * @param
     * @Date 20:36 2023/7/5
     * @Param []
     * @return void
     **/
    @Test
    public void getDishCategoryInfoTest() throws Exception {
        String  token = "eyJhbGciOiJIUzI1NiJ9.eyJyZXN0SUQiOiIwMDAwMDAxIiwicGFzc3dvcmQiOiIxNWUyYjBkM2MzMzg5MWViYjBmMWVmNjA5ZWM0MTk0MjBjMjBlMzIwY2U5NGM2NWZiYzhjMzMxMjQ0OGViMjI1IiwiZXhwIjoxNjg4NTYzNjg4fQ.yASLFAdIOxcNs69qs6KpPk_lGMRmNkIMmy0KyNyBKMg";
        String response = mockMvc.perform(MockMvcRequestBuilders.post("/adminDishCategory/getDishCategoryInfo")
                        .param("restID", "00000001")
                        .param("page","1")
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer " + token))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        DocumentContext jsonRes = JsonPath.parse(response);

        Assertions.assertEquals((int)jsonRes.read("$.code"),1);
        Assertions.assertEquals(jsonRes.read("$.msg"),"success");
    }
}