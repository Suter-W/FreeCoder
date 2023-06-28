package com.example.service;

import com.example.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface adminLoginService {

    /**
     * 餐厅管理员登录
     * @param user  餐厅实体类
     * @return User
     */

    User login(User user);
}
