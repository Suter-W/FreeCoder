package com.freecoder.mapper;

import com.freecoder.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AuthMapper {

    /**
     * 根据餐厅ID和密码登录
     * @param user
     * @return
     */
    @Select("select * from restaurants where restID = #{restID} and password = #{password};")
    User getByRestIDAndPassword(User user);

    @Insert("insert into restaurants (restID, password, RestName, RestAddr, RestPhoneNum) values (#{restID},#{password},#{RestName},#{RestAddr},#{RestPhoneNum})")
    void insertUser(User user);
}
