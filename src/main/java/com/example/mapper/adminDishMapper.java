package com.example.mapper;

import com.example.pojo.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface adminDishMapper {

    @Select("select * from dish_info where restID = #{restID}")
    List<Dish> getDishInfo(String restID);

    void addDishInfo(Dish dish);

    void updateDishInfo(Dish dish);
}
