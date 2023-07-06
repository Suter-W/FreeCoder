package com.freecoder.controller;

import com.freecoder.model.DishCategory;
import com.freecoder.model.PageBean;
import com.freecoder.model.Result;
import com.freecoder.service.AdminDishCategoryService;
import com.freecoder.service.impl.AdminDishCategoryServiceImpl;
import jakarta.annotation.security.PermitAll;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * @Description 前端传入一个整数数组————IDPresentList，其中存储修改后的dcID，使用其和restID作为where条件查找对应列，使用数组的index索引将其重新排序
     * @param restID    餐厅号
     * @param IDPresentList     前端传入的修改后的dcID
     * @Date 10:25 2023/7/5
     * @Param [java.lang.String, java.util.List<java.lang.Integer>]
     * @return com.freecoder.model.Result
     **/
    @PostMapping("/sortDishCategory")
    public Result sortDishCategory(@RequestParam String restID,@RequestBody List<Integer> IDPresentList){

        adminDishCategoryService.sortDishCategory(restID,IDPresentList);
        return Result.success("顺序更换成功");
    }


    /**
     * @Description 前端删除菜品分类时，将其对应的主键ID传到后端进行数据库删除操作，之后应再调用一次update进行顺序的更新
     * @param dcID  主键分类ID
     * @Date 14:53 2023/7/5
     * @Param [java.lang.Integer]
     * @return com.freecoder.model.Result
     **/
    @DeleteMapping("/deleteDishCategory")
    public Result deleteDishCategory(@RequestParam Integer dcID){

        adminDishCategoryService.deleteDishCategory(dcID);
        return Result.success("成功删除了该分类");

    }

}
