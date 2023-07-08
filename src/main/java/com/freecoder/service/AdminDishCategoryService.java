package com.freecoder.service;

import com.freecoder.model.DishCategory;
import com.freecoder.model.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface AdminDishCategoryService {

    List<DishCategory> getDishCategoryInfo(String restID);

    boolean addDishCategory(DishCategory dishCategory);

    boolean sortDishCategory(String restID,List<Integer> IDPresentList);

    boolean deleteDishCategory(Integer dcID);
}
