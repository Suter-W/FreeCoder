package com.freecoder.mapper;

import com.freecoder.model.Dish;
import com.freecoder.model.DishCategory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminDishMapper {

    List<Dish> getDishInfo(String restID,String dishName);

    boolean addDishInfo(Dish dish);

    boolean updateDishInfo(Dish dish);

    @Delete("delete from dish_info where dishID = #{dishID}")
    boolean deleteDishInfo(Integer dishID);
    // 秉子哥，你倒是写注释啊！！！
    @Select("select * from dish_info where restID = #{restID}")
    List<DishCategory> getDcInfo(String restID);
}
