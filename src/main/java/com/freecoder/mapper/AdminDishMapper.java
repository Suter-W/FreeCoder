package com.freecoder.mapper;

import com.freecoder.pojo.Dish;
import com.freecoder.pojo.DishCategory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminDishMapper {

    List<Dish> getDishInfo(String restID,String dishCategory,String dishName);

    void addDishInfo(Dish dish);

    void updateDishInfo(Dish dish);

    @Delete("delete from dish_info where dishID = #{dishID}")
    void deleteDishInfo(Integer dishID);
    // 秉子哥，你倒是写注释啊！！！
    @Select("select * from dish_info where restID = #{restID}")
    List<DishCategory> getDcInfo(String restID);
}
