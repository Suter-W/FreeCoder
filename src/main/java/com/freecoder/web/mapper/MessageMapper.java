package com.freecoder.web.mapper;

import com.freecoder.web.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {

    boolean addMessage(Message message);

    @Select("select * from message where restID = #{restID} order by msgTime DESC LIMIT 15")
    List<Message> getMessage(String restID);
}
