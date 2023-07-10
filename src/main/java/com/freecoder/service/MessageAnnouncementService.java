package com.freecoder.service;

import com.freecoder.model.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.SimpleTimeZone;

@Service
public interface MessageAnnouncementService {

    boolean addMessage(Message message);

    List<String> getMessage();
}
