package com.freecoder.web.mapper;

import com.freecoder.web.model.DishCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDishCategoryMapper {

    List<DishCategory> getDishCategoryInfo(String restID);

    boolean addDishCategory(DishCategory dishCategory);

    boolean sortDishCategory(String restID,List<Integer> IDPresentList);

    boolean deleteDishCategory(Integer dcID);
}