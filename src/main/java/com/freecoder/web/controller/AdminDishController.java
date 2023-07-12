package com.freecoder.web.controller;

import com.freecoder.response.MyResult;
import com.freecoder.web.model.Dish;
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
     * @return MyResult
     *
     */
    @GetMapping("/getDishInfo")
    public MyResult getDishInfo(@RequestParam String restID, @RequestParam String dishName) {
        List<Dish> dishList = adminDishService.getDishInfo(restID,dishName);
//        PageBean pageBean = adminDishService.getDishInfo(restID,page,dishCategory,dishName);
        return com.freecoder.response.MyResult.success(dishList);
    }

    /**
     * 插入dish_info表项，即添加菜品
     *
     * @param dish  菜品实体类
     * @return MyResult
     *
     */
    @PostMapping("/addDishInfo")
    public MyResult addDishInfo(@RequestBody Dish dish) {
        System.out.println(dish);
        adminDishService.addDishInfo(dish);
        return com.freecoder.response.MyResult.success("success","添加成功");
    }

    /**
     * 更改dish_info表，即更新菜品信息功能
     *
     * @param dish  菜品实体类
     * @return MyResult
     *
     */

    @PostMapping("/updateDishInfo")
    public MyResult updateDishInfo(@RequestBody Dish dish) {

        adminDishService.updateDishInfo(dish);
        return com.freecoder.response.MyResult.success("success","更新成功");
    }

    /**
     * 删除dish_info表中内容，即删除菜品
     *
     * @param dishID  菜品号
     * @return MyResult
     *
     */

    @DeleteMapping("/deleteDishInfo")
    public MyResult deleteDishInfo(@RequestParam Integer dishID) {
        adminDishService.deleteDishInfo(dishID);
        return com.freecoder.response.MyResult.success("success","删除成功");
    }
}
