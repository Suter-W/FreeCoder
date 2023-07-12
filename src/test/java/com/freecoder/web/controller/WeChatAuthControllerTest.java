package com.freecoder.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeChatAuthControllerTest {

    @Autowired
    WeChatAuthController weChatAuthController;

    //由于jsCode是一个只能使用一次的传递参数，所以只测试确保了该方法正常运行
    @Test
    void getJsCode() throws Exception{
        String jsCode = "0a3fKv000d4ihQ1YxQ200TleTR1fKv0c";

        assertNotNull(weChatAuthController.getJsCode(jsCode));
    }
}