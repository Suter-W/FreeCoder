package com.freecoder.web.mapper;

import com.freecoder.web.model.Restaurant;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AuthMapper {

    /**
     * 根据餐厅ID和密码登录
     * @param restaurant
     * @return
     */
    @Select("select * from restaurants where restID = #{restID} and password = #{password};")
    Restaurant getByRestIDAndPassword(Restaurant restaurant);

    @Insert("insert into restaurants (restID, password, RestName, RestAddr, RestPhoneNum) values (#{restID},#{password},#{RestName},#{RestAddr},#{RestPhoneNum})")
    boolean insertUser(Restaurant restaurant);
}
