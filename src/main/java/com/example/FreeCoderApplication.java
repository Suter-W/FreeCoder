package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan //开启对servlet组件支持
public class FreeCoderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreeCoderApplication.class, args);
    }

}
