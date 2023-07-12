package com.freecoder.web.controller;

import com.freecoder.web.model.Message;
import com.freecoder.web.service.MessageAnnouncementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class MessageControllerTest {

    @Autowired
    MessageAnnouncementService messageAnnouncementService;

    @Test
    @Transactional
    void addMessage() {
        Message message = new Message();
        message.setMsgContent("测试数据");
        message.setMsgTime("2023-06-26 16:50:33");
        message.setRestID("0000001");

        assertTrue(messageAnnouncementService.addMessage(message));
    }

    @Test
    void getMessage() {
        String restID = "0000001";
        assertNotNull(messageAnnouncementService.getMessage(restID));
    }
}