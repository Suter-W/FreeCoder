package com.freecoder.service.impl;

import com.freecoder.mapper.AdminLoginMapper;
import com.freecoder.pojo.User;
import com.freecoder.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

    @Autowired
    private AdminLoginMapper adminLoginMapper;

    public User login(User user){
        return adminLoginMapper.getByRestIDAndPassword(user);
    }

    public void insert(User user){
        adminLoginMapper.insertUser(user);
    }
}
