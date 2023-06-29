package com.freecoder.mapper;

import com.freecoder.pojo.Dish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface adminDishMapper {

    List<Dish> getDishInfo(String restID,String dishCategory,String dishName);

    void addDishInfo(Dish dish);

    void updateDishInfo(Dish dish);

    @Delete("delete from dish_info where dishID = #{dishID}")
    void deleteDishInfo(Integer dishID);

}
