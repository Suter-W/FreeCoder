package com.freecoder.controller;

import com.freecoder.model.Dish;
import com.freecoder.model.PageBean;
import com.freecoder.model.Result;
import com.freecoder.service.AdminDishService;
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

    @Autowired
    private ImageUploadApplication imageUploadApplication;
    /**
     * 获取菜品信息页面的全部数据
     *
     * @param restID 餐厅号
     * @return Result
     *
     */
    @GetMapping("/getDishInfo")
    public Result getDishInfo(@RequestParam String restID,@RequestParam String dishName) {
        List<Dish> dishList = adminDishService.getDishInfo(restID,dishName);
//        PageBean pageBean = adminDishService.getDishInfo(restID,page,dishCategory,dishName);
        return Result.success(dishList);
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
        System.out.println(dish);
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
