package com.freecoder.service;

import com.freecoder.pojo.DishCategory;
import com.freecoder.pojo.PageBean;
import org.springframework.stereotype.Service;

@Service
public interface AdminDishCategoryService {

    PageBean getDishCategoryInfo(String restID,Integer page);

    void addDishCategory(DishCategory dishCategory);
}
