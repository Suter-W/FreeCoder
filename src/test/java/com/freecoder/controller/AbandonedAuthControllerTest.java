package com.freecoder.controller;

//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//
//import static com.freecoder.utils.RSAEncrypt.*;

//本测试是前期使用http请求测试login方法，由于maven打包无法通过测试，已经弃用，仅用于参考！！！

class AbandonedAuthControllerTest {

//    @Test
//    void loginTest() throws Exception {
//        String restID = "0000001";
//        String password = "123456789";
//        String url = "http://localhost:8088/login";
//
//        //密码将进行sh256加密,然后发送到服务器服务器
////        password = DigestUtils.sha256Hex(password);
//        String requestBody = String.format("{\"restID\":\"%s\",\"password\":\"%s\"}",restID,password);
//
//        //rsa加密
//        String pubKey = loadKey( "docs/id_rsa.pub");
//        requestBody = encrypt(requestBody,pubKey);
//        requestBody = URLEncoder.encode(requestBody, "UTF-8");
//        System.out.println(requestBody);
//
//        URL apiUrl = new URL(url);
//        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
//        connection.setRequestMethod("POST");
//        connection.setDoOutput(true);
//
//        try (OutputStream outputStream = connection.getOutputStream()) {
//            byte[] requestBodyBytes = requestBody.getBytes("UTF-8");
//            outputStream.write(requestBodyBytes, 0, requestBodyBytes.length);
//            outputStream.flush();
//        }
//
//        // 处理服务器的响应
//        int statusCode = connection.getResponseCode();
//        System.out.println("Response Code: " + statusCode);
//
//        BufferedReader reader;
//        if (statusCode == HttpURLConnection.HTTP_OK) {
//            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        } else {
//            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
//        }
//
//        String line;
//        StringBuilder response = new StringBuilder();
//        while ((line = reader.readLine()) != null) {
//            response.append(line);
//        }
//        reader.close();
//        System.out.println("Response Body: " + response.toString());
//        Assertions.assertTrue(statusCode==200);
//    }

}