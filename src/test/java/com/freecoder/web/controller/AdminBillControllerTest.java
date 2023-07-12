package com.freecoder.web.controller;

import com.freecoder.web.service.AdminBillService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminBillControllerTest {

    @Autowired
    AdminBillService adminBillService;

    @Test
    void getHistoricalOrders() {
        assertNotNull(adminBillService.getHistoricalOrders("0000001"));
    }

    @Test
    void getHistoricalOrderDetails() {
        assertNotNull(adminBillService.getHistoricalOrderDetails("0000001",3));
    }
}