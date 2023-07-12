package com.freecoder.web.mapper;


import com.freecoder.web.model.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminEmployeeMapper {

    @Select("select * from employee where restID = #{restID}")
    List<Employee> getEmployeeList(String restID);

    @Update("update employee set restID=#{restID},type=#{type} where phone_num = #{phone_num}")
    void addEmployee(String restID, String phone_num, String type);

    @Delete("delete from employee where phone_num = #{phone_num}")
    void deleteEmployee(String phone_num);
}
