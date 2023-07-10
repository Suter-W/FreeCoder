package com.freecoder.web.service;

import com.freecoder.web.model.DishCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminDishCategoryService {

    List<DishCategory> getDishCategoryInfo(String restID);

    boolean addDishCategory(DishCategory dishCategory);

    boolean sortDishCategory(String restID,List<Integer> IDPresentList);

    boolean deleteDishCategory(Integer dcID);
}
