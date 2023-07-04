package com.freecoder.service.impl;

import com.freecoder.mapper.AdminDishCategoryMapper;
import com.freecoder.pojo.DishCategory;
import com.freecoder.pojo.Dish;
import com.freecoder.pojo.PageBean;
import com.freecoder.service.AdminDishCategoryService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AdminDishCategoryServiceImpl
 * @Description TODO
 * @DATE 2023/7/4 10:50
 */
@Service
public class AdminDishCategoryServiceImpl implements AdminDishCategoryService {

    @Autowired
    private AdminDishCategoryMapper adminDishCategoryMapper;


    @Override
    public PageBean getDishCategoryInfo(String restID,Integer page){
//        //设置分页参数
//        PageHelper.startPage(page,5);
//        List<DishCategory> dishCategoryList = adminDishCategoryMapper.getDishCategoryInfo(restID);
//        Page<DishCategory> dishCategoryPage = (Page<DishCategory>) dishCategoryList;
//        PageBean pageBean = new PageBean(dishCategoryPage.getTotal(),dishCategoryPage.getResult());
//        return pageBean;

        // 设置分页参数
        PageHelper.startPage(page, 5);
        List<DishCategory> dishCategoryList = adminDishCategoryMapper.getDishCategoryInfo(restID);
        PageInfo<DishCategory> pageInfo = new PageInfo<>(dishCategoryList);
        PageBean pageBean = new PageBean(pageInfo.getTotal(), pageInfo.getList());
        return pageBean;
    }

    public void addDishCategory(DishCategory dishCategory){
        adminDishCategoryMapper.addDishCategory(dishCategory);
    }

}