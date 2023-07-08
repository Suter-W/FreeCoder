package com.freecoder.service;

import com.freecoder.model.Dish;
import com.freecoder.model.DishCategory;
import com.freecoder.model.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminDishService {

    List<Dish> getDishInfo(String restID,String dishName);

    boolean addDishInfo(Dish dish);

    boolean updateDishInfo(Dish dish);

    boolean deleteDishInfo(Integer dishID);

    List<DishCategory> getDcInfo(String restID);
}
