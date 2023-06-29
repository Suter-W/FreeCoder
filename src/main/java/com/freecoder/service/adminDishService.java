package com.freecoder.service;

import com.freecoder.pojo.Dish;
import com.freecoder.pojo.PageBean;

public interface adminDishService {

    PageBean getDishInfo(String restID, Integer page, String dishCategory, String dishName);

    void addDishInfo(Dish dish);

    void updateDishInfo(Dish dish);

    void deleteDishInfo(Integer dishID);
}
