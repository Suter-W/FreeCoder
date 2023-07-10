package com.freecoder.web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    @Id
    private String restID; //餐厅ID

    private String dishImage; //菜品图片

    private String dishName; //菜品名称

    private String dishDescription; //菜品描述

    private String dishPrice; //菜品价格

    private String dishCategory; //菜品分类

    private Integer dishID; //菜品ID

    private String VipPrice; //折扣价格

    private Integer dcID;//菜品种类的ID，主要用于外键

    private Integer salesVolume;//菜品销量
}
