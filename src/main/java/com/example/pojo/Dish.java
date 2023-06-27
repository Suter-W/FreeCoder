package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

    private String restID; //餐厅ID

    private String dishImage; //菜品图片

    private String dishName; //菜品名称

    private String dishDescription; //菜品描述

    private String dishPrice; //菜品价格

    private String dishCategory; //菜品分类

    private Integer dishID; //菜品ID

    private String VipPrice; //折扣价格
}
