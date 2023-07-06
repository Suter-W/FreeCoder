package com.freecoder.service;

import com.freecoder.model.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    /**
     * 餐厅管理员登录
     * @param user  餐厅实体类
     * @return User
     */
    
    User login(User user);

    boolean insert(User user);
}
