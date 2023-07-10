package com.freecoder.web.service;

import com.freecoder.web.model.Dish;
import com.freecoder.web.model.DishCategory;
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
