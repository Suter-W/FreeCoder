package com.freecoder.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

class AuthControllerTest {

    @Test
    void loginTest() {
        String passwordSha256 = DigestUtils.sha256Hex("123456789");
        System.out.println(passwordSha256);
    }
}