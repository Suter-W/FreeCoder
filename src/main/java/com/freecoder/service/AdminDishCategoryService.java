package com.freecoder.service;

import com.freecoder.model.DishCategory;
import com.freecoder.model.PageBean;
import org.springframework.stereotype.Service;

@Service
public interface AdminDishCategoryService {

    PageBean getDishCategoryInfo(String restID,Integer page);

    void addDishCategory(DishCategory dishCategory);
}
