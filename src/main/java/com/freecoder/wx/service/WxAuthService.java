package com.freecoder.wx.service;

import com.freecoder.response.result.Result;
import com.freecoder.wx.model.Customer;

public interface WxAuthService {
    Result login(String code);

    Result register(Customer customer);

    Result refreshToken(String code);
}
