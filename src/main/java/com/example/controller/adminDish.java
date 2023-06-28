package com.example.controller;

import com.example.pojo.Dish;
import com.example.pojo.Result;
import com.example.service.adminDishService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequestMapping("adminDish")
@PermitAll
@CrossOrigin
public class adminDish {
    @Autowired
    private adminDishService adminDishService;

    /**
     * 获取菜品信息页面的全部数据
     *
     * @param restID 餐厅号
     * @return Result
     *
     */
    @GetMapping("/getDishInfo")
    public Result getDishInfo(@RequestParam String restID) {
        List<Dish> dish = adminDishService.getDishInfo(restID);
        return Result.success(dish);
    }

    /**
     * 插入dish_info表项，即添加菜品
     *
     * @param dish  菜品实体类
     * @return Result
     *
     */
    @PostMapping("/addDishInfo")
    public Result addDishInfo(@RequestBody Dish dish) {
        adminDishService.addDishInfo(dish);
        return Result.success();
    }

    /**
     * 更改dish_info表，即更新菜品信息功能
     *
     * @param dish  菜品实体类
     * @return Result
     *
     */

    @PostMapping("/updateDishInfo")
    public Result updateDishInfo(@RequestBody Dish dish) {

        adminDishService.updateDishInfo(dish);
        return Result.success();
    }

    /**
     * 删除dish_info表中内容，即删除菜品
     *
     * @param dishID  菜品号
     * @return Result
     *
     */

    @DeleteMapping("/deleteDishInfo")
    public Result deleteDishInfo(@RequestParam Integer dishID) {
        adminDishService.deleteDishInfo(dishID);
        return Result.success();
    }
}
