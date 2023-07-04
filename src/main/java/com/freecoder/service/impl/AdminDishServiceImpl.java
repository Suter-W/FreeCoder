package com.freecoder.service.impl;

import com.freecoder.mapper.AdminDishMapper;
import com.freecoder.pojo.Dish;
import com.freecoder.pojo.DishCategory;
import com.freecoder.pojo.PageBean;
import com.freecoder.service.AdminDishService;
import com.github.pagehelper.Page;
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
    public PageBean getDishInfo(String restID, Integer page, String dishCategory, String dishName){
        //设置分页参数
//        PageHelper.startPage(page,5);
//        List<Dish> dishList = adminDishMapper.getDishInfo(restID,dishCategory,dishName);
//        Page<Dish> p = (Page<Dish>) dishList;
//        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
//        return pageBean;

        //设置分页参数
        PageHelper.startPage(page,5);
        List<Dish> dishList = adminDishMapper.getDishInfo(restID,dishCategory,dishName);
        PageInfo<Dish> p = new PageInfo<>(dishList);

        PageBean pageBean = new PageBean(p.getTotal(),p.getList());
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

    public List<DishCategory> getDcInfo(String restID){return adminDishMapper.getDcInfo(restID);}

}
