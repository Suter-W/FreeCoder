package com.example.service.impl;

import com.example.pojo.Dish;
import com.example.mapper.adminDishMapper;
import com.example.service.adminDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminDishImpl implements adminDishService {

    @Autowired
    private adminDishMapper adminDishMapper;

    @Override
    public List<Dish> getDishInfo(String restID){
        return adminDishMapper.getDishInfo(restID);
    }

    public void addDishInfo(Dish dish){
        adminDishMapper.addDishInfo(dish);
    }

    public void updateDishInfo(Dish dish){
        adminDishMapper.updateDishInfo(dish);
    }

}
