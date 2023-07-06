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


//@RunWith(SpringRunner.class)//表明要在测试环境跑了，底层使用的junit测试工具
@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testLogin() throws Exception {
        String response = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .content("frDqyqoWf5nzGZSsOPWSf5bR8RifIWbtqWhNJjWehv296FBumOirU8z1p4%2BF5rsfZX2uj3JcUfEeIsSUx4J2mg8%2B%2FSYXJ9EdlLOOGCuGkT56MaIFI15y20WaZAwhcambLccTfrAzWFYGzf5RnXpuOQu76CzNRn3b8jDQOw%2F9IWA%3D")
                        .header("Content-Type", "application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        DocumentContext jsonRes = JsonPath.parse(response);

        Assertions.assertEquals((int)jsonRes.read("$.code"),1);
        Assertions.assertEquals(jsonRes.read("$.msg"),"success");
    }
}