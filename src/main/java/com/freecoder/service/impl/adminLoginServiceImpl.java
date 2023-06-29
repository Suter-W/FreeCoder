package com.freecoder.service.impl;

import com.freecoder.mapper.adminLoginMapper;
import com.freecoder.pojo.User;
import com.freecoder.service.adminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminLoginServiceImpl implements adminLoginService {

    @Autowired
    private adminLoginMapper adminLoginMapper;

    public User login(User user){
        return adminLoginMapper.getByRestIDAndPassword(user);
    }

    public void insert(User user){
        adminLoginMapper.insertUser(user);
    }
}
