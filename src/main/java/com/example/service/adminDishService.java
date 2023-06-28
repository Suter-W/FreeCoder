package com.example.service;

import com.example.pojo.Dish;
import com.example.pojo.PageBean;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface adminDishService {

    PageBean getDishInfo(String restID, Integer page, String dishCategory, String dishName);

    void addDishInfo(Dish dish);

    void updateDishInfo(Dish dish);

    void deleteDishInfo(Integer dishID);
}
