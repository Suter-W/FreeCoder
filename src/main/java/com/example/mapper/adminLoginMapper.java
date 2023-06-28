package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface adminLoginMapper {

    /**
     * 根据餐厅ID和密码登录
     * @param user
     * @return
     */
    @Select("select * from restaurants where restID = #{restID} and password = #{password};")
    User getByRestIDAndPassword(User user);

}
