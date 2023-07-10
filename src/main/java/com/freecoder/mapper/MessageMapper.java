package com.freecoder.mapper;

import com.freecoder.model.Dish;
import com.freecoder.model.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface MessageMapper {

    boolean addMessage(Message message);

    @Select("select * from message order by msgTime DESC LIMIT 1")
    List<String> getMessage();
}
