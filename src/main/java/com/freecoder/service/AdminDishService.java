package com.freecoder.service;

import com.freecoder.pojo.Dish;
import com.freecoder.pojo.DishCategory;
import com.freecoder.pojo.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminDishService {

    PageBean getDishInfo(String restID, Integer page, String dishCategory, String dishName);

    void addDishInfo(Dish dish);

    void updateDishInfo(Dish dish);

    void deleteDishInfo(Integer dishID);

    List<DishCategory> getDcInfo(String restID);
}
