package com.freecoder.mapper;

import com.freecoder.model.DishCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminDishCategoryMapper {

    List<DishCategory> getDishCategoryInfo(String restID);

    boolean addDishCategory(DishCategory dishCategory);

    boolean sortDishCategory(String restID,List<Integer> IDPresentList);

    boolean deleteDishCategory(Integer dcID);


    @Select("select * from dish_category where dcID = #{dcID}")
    DishCategory searchDishByid(Integer dcID);
}
