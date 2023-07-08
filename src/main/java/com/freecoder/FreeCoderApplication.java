package com.freecoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@ServletComponentScan //开启对servlet组件支持
@EnableWebSocket //启用WebSocket功能
public class FreeCoderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreeCoderApplication.class, args);
    }

}
