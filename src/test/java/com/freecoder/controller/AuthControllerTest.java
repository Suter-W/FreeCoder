package com.freecoder.controller;

import com.freecoder.web.model.Restaurant;
import com.freecoder.web.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
//@ExtendWith(SpringExtension.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    AuthService authService;

//    @Test
//    public void testLogin() throws Exception {
//        String response = mockMvc.perform(MockMvcRequestBuilders.post("/login")
//                        .content("frDqyqoWf5nzGZSsOPWSf5bR8RifIWbtqWhNJjWehv296FBumOirU8z1p4%2BF5rsfZX2uj3JcUfEeIsSUx4J2mg8%2B%2FSYXJ9EdlLOOGCuGkT56MaIFI15y20WaZAwhcambLccTfrAzWFYGzf5RnXpuOQu76CzNRn3b8jDQOw%2F9IWA%3D")
//                        .header("Content-Type", "application/json"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn().getResponse().getContentAsString();
//        DocumentContext jsonRes = JsonPath.parse(response);
//
//        Assertions.assertEquals((int)jsonRes.read("$.code"),1);
//        Assertions.assertEquals(jsonRes.read("$.msg"),"success");
//    }

    @Test
    public void testLogin() throws Exception {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestID("0000001");
        restaurant.setPassword("123456789");

        assertNotNull(authService.login(restaurant));
    }

}