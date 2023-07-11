package com.freecoder.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ImageUploadApplication.class)
@AutoConfigureMockMvc
public class ImageUploadApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUploadImage() throws Exception {
//        File file = ResourceUtils.getFile("classpath:test_image.jpg"); // 替换为你自己的测试图片路径
        File file = new File("E:/DeskTop/f392a69f33abe511cf0408a9f3c9b28.jpg");
        FileInputStream input = new FileInputStream(file);
        MockMultipartFile multipartFile = new MockMultipartFile("image", file.getName(), "image/jpeg", input);
        System.out.println("链接："+multipartFile);
        mockMvc.perform(
                        multipart("/web/upload")
                                .file(multipartFile)
                                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.imageUrl").isString());
        System.out.println("55555555"+jsonPath("$.imageUrl"));;
    }
}