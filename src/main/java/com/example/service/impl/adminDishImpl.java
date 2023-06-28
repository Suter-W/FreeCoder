package com.example.service.impl;

import com.example.pojo.Dish;
import com.example.mapper.adminDishMapper;
import com.example.pojo.PageBean;
import com.example.service.adminDishService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminDishImpl implements adminDishService {

    @Autowired
    private adminDishMapper adminDishMapper;

    @Override
    public PageBean getDishInfo(String restID, Integer page, String dishCategory, String dishName){
        //设置分页参数
        PageHelper.startPage(page,5);
        List<Dish> dishList = adminDishMapper.getDishInfo(restID,dishCategory,dishName);
        Page<Dish> p = (Page<Dish>) dishList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    public void addDishInfo(Dish dish){
        adminDishMapper.addDishInfo(dish);
    }

    public void updateDishInfo(Dish dish){
        adminDishMapper.updateDishInfo(dish);
    }

    public void deleteDishInfo(Integer dishID){
        adminDishMapper.deleteDishInfo(dishID);
    }

}
