package com.freecoder.web.controller;


import com.freecoder.web.model.Message;
import com.freecoder.response.Result;
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
    public Result addMessage(@RequestBody Message message){
        System.out.println(message);
        messageAnnouncementService.addMessage(message);
        return Result.success("success","公告添加成功");
    }

    @GetMapping("/getMessage")
    public Result getMessage(@RequestParam String restID){
        List<Message> msgList = messageAnnouncementService.getMessage(restID);
        return Result.success(msgList);
    }

}
