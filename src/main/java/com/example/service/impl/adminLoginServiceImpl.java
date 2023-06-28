package com.example.service.impl;

import com.example.mapper.adminLoginMapper;
import com.example.pojo.User;
import com.example.service.adminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminLoginServiceImpl implements adminLoginService {

    @Autowired
    private adminLoginMapper adminLoginMapper;

    public User login(User user){
        return adminLoginMapper.getByRestIDAndPassword(user);
    }
}
