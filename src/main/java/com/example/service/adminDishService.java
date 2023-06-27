package com.example.service;

import com.example.pojo.Dish;

import java.util.List;

public interface adminDishService {

    List<Dish> getDishInfo(String restID);

    void addDishInfo(Dish dish);

    void updateDishInfo(Dish dish);
}
