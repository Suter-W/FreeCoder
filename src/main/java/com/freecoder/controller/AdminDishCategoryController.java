package com.freecoder.controller;

import com.freecoder.model.DishCategory;
import com.freecoder.model.PageBean;
import com.freecoder.model.Result;
import com.freecoder.service.AdminDishCategoryService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName AdminDishCategoryController
 * @Description TODO
 * @DATE 2023/7/4 10:43
 */
@RestController
@RequestMapping("adminDishCategory")
@PermitAll
@CrossOrigin
public class AdminDishCategoryController {

    @Autowired
    private AdminDishCategoryService adminDishCategoryService;

    @PostMapping("/getDishCategoryInfo")
    public Result getDishCategoryInfo(@RequestParam String restID,@RequestParam(defaultValue = "1") Integer page){
        PageBean pageBean = adminDishCategoryService.getDishCategoryInfo(restID,page);
        return Result.success(pageBean);
    }


    @PostMapping("/addDishCategory")
    public Result addDishCategory(@RequestBody DishCategory dishCategory){

        adminDishCategoryService.addDishCategory(dishCategory);
        return Result.success();
    }


//    public Result updateDishCategory()
}
