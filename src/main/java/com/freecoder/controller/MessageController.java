package com.freecoder.controller;


import com.freecoder.model.Message;
import com.freecoder.model.Result;
import com.freecoder.service.MessageAnnouncementService;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        return Result.success("公告添加成功");
    }

    @GetMapping("/getMessage")
    public Result getMessage(){
        List<String> msgList = messageAnnouncementService.getMessage();
        return Result.success(msgList);
    }

}
