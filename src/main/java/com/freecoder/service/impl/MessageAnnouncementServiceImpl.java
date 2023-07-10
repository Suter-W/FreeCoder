package com.freecoder.service.impl;

import com.freecoder.mapper.MessageMapper;
import com.freecoder.model.Message;
import com.freecoder.service.MessageAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MessageAnnouncementServiceImpl
 * @Description TODO
 * @DATE 2023/7/10 11:00
 */
@Service
public class MessageAnnouncementServiceImpl implements MessageAnnouncementService {

    @Autowired
    private MessageMapper messageMapper;

    public boolean addMessage(Message message){
        boolean addMessageStatus = messageMapper.addMessage(message);
        return addMessageStatus;
    }

    public List<String> getMessage(){
        List<String> msgMessage = messageMapper.getMessage();
        return msgMessage;
    }
}
