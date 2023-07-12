package com.freecoder.web.controller;


import com.freecoder.response.MyResult;
import com.freecoder.web.model.Message;
import com.freecoder.web.service.MessageAnnouncementService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName MessageController
 * @Description TODO
 * @DATE 2023/7/10 11:09
 */

@RestController
@CrossOrigin
@PermitAll
@RequestMapping("/web")
public class MessageController {

    @Autowired
    private MessageAnnouncementService messageAnnouncementService;

    @PostMapping("/addMessage")
    public MyResult addMessage(@RequestBody Message message){
        System.out.println(message);
        messageAnnouncementService.addMessage(message);
        return com.freecoder.response.MyResult.success("success","公告添加成功");
    }

    @GetMapping("/getMessage")
    public MyResult getMessage(@RequestParam String restID){
        List<Message> msgList = messageAnnouncementService.getMessage(restID);
        return com.freecoder.response.MyResult.success(msgList);
    }

}
