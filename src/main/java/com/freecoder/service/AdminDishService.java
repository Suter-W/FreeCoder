package com.freecoder.service;

import com.freecoder.model.Dish;
import com.freecoder.model.DishCategory;
import com.freecoder.model.PageBean;
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
