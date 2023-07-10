package com.freecoder.wx.service;

import com.freecoder.web.model.Result;
import com.freecoder.wx.model.Customer;

public interface WxAuthService {
    Result login(String code);

    Result insert(Customer customer);
}
