package com.freecoder.web.service.impl;

import com.freecoder.web.service.AdminBillService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AdminBillServiceImplTest {


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

    @Test
    void getHistoricalBill() {
    }
}