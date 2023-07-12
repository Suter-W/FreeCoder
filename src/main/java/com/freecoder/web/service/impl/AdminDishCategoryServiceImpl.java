package com.freecoder.web.service.impl;

import com.freecoder.web.mapper.AdminDishCategoryMapper;
import com.freecoder.web.model.DishCategory;
import com.freecoder.web.service.AdminDishCategoryService;
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

    public DishCategory searchDishByid(Integer dcID){return adminDishCategoryMapper.searchDishByid(dcID);}
}
