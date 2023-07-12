package com.freecoder.web.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface EmployeeManageMapper {

    @Insert("")
    boolean addEmploy();

    @Select("")
    List<String> getEmployInfo();

    @Update("")
    boolean refineEmployInfo();
}
