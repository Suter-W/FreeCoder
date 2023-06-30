package com.freecoder.service.impl;

import com.freecoder.mapper.AuthMapper;
import com.freecoder.pojo.User;
import com.freecoder.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthMapper authMapper;

    public User login(User user){
        return authMapper.getByRestIDAndPassword(user);
    }

    public void insert(User user){
        authMapper.insertUser(user);
    }
}
