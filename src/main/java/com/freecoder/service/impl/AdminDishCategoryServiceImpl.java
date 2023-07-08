package com.freecoder.service.impl;

import com.freecoder.mapper.AdminDishCategoryMapper;
import com.freecoder.model.DishCategory;
import com.freecoder.model.PageBean;
import com.freecoder.service.AdminDishCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Map;

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
    public List<DishCategory> getDishCategoryInfo(String restID){
//        //设置分页参数
//        PageHelper.startPage(page,5);
//        List<DishCategory> dishCategoryList = adminDishCategoryMapper.getDishCategoryInfo(restID);
//        Page<DishCategory> dishCategoryPage = (Page<DishCategory>) dishCategoryList;
//        PageBean pageBean = new PageBean(dishCategoryPage.getTotal(),dishCategoryPage.getResult());
//        return pageBean;

        // 设置分页参数
            return adminDishCategoryMapper.getDishCategoryInfo(restID);
    }

    public boolean addDishCategory(DishCategory dishCategory){
        boolean addDishCategoryStatus = adminDishCategoryMapper.addDishCategory(dishCategory);
        return addDishCategoryStatus;
    }

//    public void sortDishCategory(DishCategory dishCategory,List<Integer> dcOrderList,List<Integer> dcOrderListOriginal){
//        adminDishCategoryMapper.sortDishCategory(dishCategory,dcOrderList,dcOrderListOriginal);
//    }

    public boolean sortDishCategory(String restID,List<Integer> IDPresentList){
        boolean sortDishCategoryStatus = adminDishCategoryMapper.sortDishCategory(restID, IDPresentList);
        return sortDishCategoryStatus;
    }

    public boolean deleteDishCategory(Integer dcID){
        boolean deleteDishCategoryStatus = adminDishCategoryMapper.deleteDishCategory(dcID);
        return deleteDishCategoryStatus;
    }

}
