package com.freecoder.service.impl;

import com.freecoder.mapper.AuthMapper;
import com.freecoder.model.User;
import com.freecoder.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthMapper authMapper;

    @Override
    public User login(User user){
        return authMapper.getByRestIDAndPassword(user);
    }

    public boolean insert(User user){
        boolean insertStatus = authMapper.insertUser(user);
        return insertStatus;
    }
}
