package com.freecoder.web.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//分页查询结果封装类

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private  long totals;  //总记录数
    private List rows;    //当前页记录
}
