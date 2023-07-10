package com.freecoder.web.controller;

import com.freecoder.web.model.Dish;
import com.freecoder.web.model.Result;
import com.freecoder.web.service.AdminDishService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/web/adminDish")
@PermitAll
@CrossOrigin
public class AdminDishController {
    @Autowired
    private AdminDishService adminDishService;

    /**
     * 获取菜品信息页面的全部数据
     *
     * @param restID 餐厅号
     * @return Response
     *
     */
    @GetMapping("/getDishInfo")
    public Result getDishInfo(@RequestParam String restID, @RequestParam String dishName) {
        List<Dish> dishList = adminDishService.getDishInfo(restID,dishName);
//        PageBean pageBean = adminDishService.getDishInfo(restID,page,dishCategory,dishName);
        return Result.success(dishList);
    }

    /**
     * 插入dish_info表项，即添加菜品
     *
     * @param dish  菜品实体类
     * @return Response
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
     * @return Response
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
     * @return Response
     *
     */

    @DeleteMapping("/deleteDishInfo")
    public Result deleteDishInfo(@RequestParam Integer dishID) {
        adminDishService.deleteDishInfo(dishID);
        return Result.success();
    }
}
