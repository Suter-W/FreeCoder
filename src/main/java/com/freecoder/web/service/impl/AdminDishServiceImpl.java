package com.freecoder.web.service.impl;

import com.freecoder.web.mapper.AdminDishMapper;
import com.freecoder.web.model.Dish;
import com.freecoder.web.model.DishCategory;
import com.freecoder.web.service.AdminDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminDishServiceImpl implements AdminDishService {

    @Autowired
    private AdminDishMapper adminDishMapper;

    @Override
    public List<Dish> getDishInfo(String restID,String dishName){return adminDishMapper.getDishInfo(restID,dishName);}

    public boolean addDishInfo(Dish dish){
        boolean addDishInfoStatus = adminDishMapper.addDishInfo(dish);
        return  addDishInfoStatus;
    }

    public boolean updateDishInfo(Dish dish){
        boolean updateDishInfoStatus = adminDishMapper.updateDishInfo(dish);
        return updateDishInfoStatus;
    }

    public boolean deleteDishInfo(Integer dishID){
        boolean deleteDishInfoStatus = adminDishMapper.deleteDishInfo(dishID);
        return deleteDishInfoStatus;
    }

    public List<DishCategory> getDcInfo(String restID){return adminDishMapper.getDcInfo(restID);}

}
