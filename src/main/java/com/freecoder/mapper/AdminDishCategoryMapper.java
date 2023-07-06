package com.freecoder.mapper;

import com.freecoder.model.DishCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminDishCategoryMapper {

    List<DishCategory> getDishCategoryInfo(String restID);

    void addDishCategory(DishCategory dishCategory);

    void sortDishCategory(String restID,List<Integer> IDPresentList);

    void deleteDishCategory(Integer dcID);
}
