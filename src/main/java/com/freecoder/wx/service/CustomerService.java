package com.freecoder.wx.service;

import com.freecoder.response.result.ResultException;
import com.freecoder.wx.model.Customer;

public interface CustomerService {
    Customer getCustomerInfo(Long code);

    public Customer updateCustomerNameAndAvatar(String nickName, String avatarUrl, Long id) throws ResultException;

    public Customer updateCustomerVipInfo(Boolean isVip, Long id) throws ResultException;

}
