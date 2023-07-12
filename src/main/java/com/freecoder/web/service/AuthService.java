package com.freecoder.web.service;

import com.freecoder.web.model.Restaurant;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    /**
     * 餐厅管理员登录
     * @param restaurant  餐厅实体类
     * @return Restaurant
     */
    
    Restaurant login(Restaurant restaurant);

}
