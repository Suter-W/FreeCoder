package com.freecoder.web.service;

import com.freecoder.web.model.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageAnnouncementService {

    boolean addMessage(Message message);

    List<Message> getMessage(String restID);
}
