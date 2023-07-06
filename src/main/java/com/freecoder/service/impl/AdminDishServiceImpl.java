package com.freecoder.service.impl;

import com.freecoder.mapper.AdminDishMapper;
import com.freecoder.model.Dish;
import com.freecoder.model.DishCategory;
import com.freecoder.model.PageBean;
import com.freecoder.service.AdminDishService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminDishServiceImpl implements AdminDishService {

    @Autowired
    private AdminDishMapper adminDishMapper;

    @Override
    public List<Dish> getDishInfo(String restID,String dishName){return adminDishMapper.getDishInfo(restID,dishName);}

    public void addDishInfo(Dish dish){
        adminDishMapper.addDishInfo(dish);
    }

    public void updateDishInfo(Dish dish){
        adminDishMapper.updateDishInfo(dish);
    }

    public void deleteDishInfo(Integer dishID){
        adminDishMapper.deleteDishInfo(dishID);
    }

    public List<DishCategory> getDcInfo(String restID){return adminDishMapper.getDcInfo(restID);}

}
