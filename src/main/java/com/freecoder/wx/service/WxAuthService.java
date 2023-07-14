package com.freecoder.wx.service;

import com.freecoder.response.result.Result;
import com.freecoder.wx.model.Customer;
import com.freecoder.wx.model.Employee;

public interface WxAuthService {
    Result login(String code);

    Result register(Customer customer);

    Result employeeLogin(String code);

    Result register(Employee employee);

    Result refreshToken(String code);
}
