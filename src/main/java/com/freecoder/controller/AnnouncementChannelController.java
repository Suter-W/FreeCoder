package com.freecoder.controller;

import com.freecoder.model.Result;
import com.freecoder.utils.GoEasyServer;
import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;
import jakarta.annotation.security.PermitAll;
import org.apache.kerby.cms.type.PasswordRecipientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @ClassName AnnouncementChannelController
 * @Description TODO
 * @DATE 2023/7/8 16:07
 */

@RestController
@CrossOrigin
@PermitAll
@RequestMapping("/web")
public class AnnouncementChannelController {

    private final Queue<DeferredResult<String>> connections = new ConcurrentLinkedQueue<>();

    @GetMapping("/getPolling")
    public Result getPolling(@RequestParam String polling){
        GoEasy goEasy = new GoEasy("https://rest-hz.goeasy.io","BC-a0191921df274d3f826449fca32b26e9");
        goEasy.publish("my_channel", polling, new PublishListener() {
            @Override
            public void onSuccess() {
                System.out.println("Publish success.");
            }

            @Override
            public void onFailed(GoEasyError error) {
                System.out.println("Failed to Publish message, error:" + error.getCode() + " , " + error.getContent());
            }
        });
        return Result.success("连接成功");
    }

    @GetMapping("/long-polling")
    public void handleLongPolling(@RequestParam String message) {
        DeferredResult<String> result = new DeferredResult<>(30000L);  // 设置超时时间，这里为30秒
        System.out.println(result);
        System.out.println(message);
        // 将请求添加到连接队列
        connections.add(result);
        System.out.println(connections);
        // 请求完成时，从队列中移除
        result.onCompletion(() -> connections.remove(result));
    }

    // 处理发送消息的请求

    @Async
    @PostMapping("/send-message")
    public void sendMessage(@RequestBody String message) {
        // 遍历连接队列，发送消息给所有等待的连接
        System.out.println(message);
        connections.forEach(connection -> connection.setResult(message));
        System.out.println(connections);
    }


}
