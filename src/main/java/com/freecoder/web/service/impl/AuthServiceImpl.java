package com.freecoder.web.service.impl;

import com.freecoder.web.mapper.AuthMapper;
import com.freecoder.web.model.Restaurant;
import com.freecoder.web.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthMapper authMapper;

    @Override
    public Restaurant login(Restaurant restaurant){
        return authMapper.getByRestIDAndPassword(restaurant);
    }

}
