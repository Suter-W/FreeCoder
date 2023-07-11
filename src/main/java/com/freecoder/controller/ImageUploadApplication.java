package com.freecoder.controller;

/**
 * @ClassName ImageUploadApplication
 * @Description TODO
 * @DATE 2023/7/10 17:20
 */
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@Slf4j
@RestController
public class ImageUploadApplication {

    // 设置图片保存目录
    private static final String IMAGE_DIRECTORY = "E:\\imageTest/";

    @PostMapping(value = "/web/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UploadResponse uploadImage(@RequestPart("image") MultipartFile image) {
        System.out.println(image);
        try {
            // 生成唯一的文件名
            String fileName = UUID.randomUUID().toString() + "-" + image.getOriginalFilename();
            System.out.println(fileName);
            // 存储图片到服务器
            File file = new File(IMAGE_DIRECTORY + fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(image.getBytes());
            fos.close();

            // 构造图片URL链接
            String imageUrl = "E:\\imageTest/" + fileName;

            return new UploadResponse(true, imageUrl);
        } catch (IOException e) {
            return new UploadResponse(false, null);
        }
    }

    private static class UploadResponse {
        private boolean success;
        private String imageUrl;

        public UploadResponse(boolean success, String imageUrl) {
            this.success = success;
            this.imageUrl = imageUrl;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getImageUrl() {
            return imageUrl;
        }
    }


}
