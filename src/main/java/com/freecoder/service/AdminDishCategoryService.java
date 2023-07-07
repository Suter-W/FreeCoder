package com.freecoder.service;

import com.freecoder.model.DishCategory;
import com.freecoder.model.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface AdminDishCategoryService {

    List<DishCategory> getDishCategoryInfo(String restID);

    void addDishCategory(DishCategory dishCategory);

    void sortDishCategory(String restID,List<Integer> IDPresentList);

    void deleteDishCategory(Integer dcID);

    DishCategory searchDishByid(Integer dcID);
}
