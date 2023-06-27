package com.example.controller;

import com.example.pojo.Dish;
import com.example.pojo.Result;
import com.example.service.adminDishService;
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

    //获取菜品信息页面的全部数据
    @GetMapping("/getDishInfo")
    public Result getDishInfo(@RequestParam String restID){
        List<Dish> dish = adminDishService.getDishInfo(restID);
        return Result.success(dish);
    }

    //对dish_info表进行插入，及添加菜品功能

    @PostMapping("/addDishInfo")
    public Result addDishInfo(@RequestBody Dish dish){
        adminDishService.addDishInfo(dish);
        return Result.success();
    }

    //更改dish_info表，及更新菜品信息功能
    @PostMapping("/updateDishInfo")
    public Result updateDishInfo(@RequestBody Dish dish){

        adminDishService.updateDishInfo(dish);
        return Result.success();
    }
}
