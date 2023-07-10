package com.freecoder.web.controller;

import com.freecoder.utils.MyWebSocketHandler;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * @ClassName AnnouncementChannelController
 * @Description TODO
 * @DATE 2023/7/8 9:17
 */

@RestController
@CrossOrigin
@PermitAll
@RequestMapping("/web")
public class AnnouncementChannelController {

    @Autowired
    private MyWebSocketHandler myCustomWebSocketHandler;

    @RequestMapping("/send-message")
    public void sendMessageToAllClients(@RequestParam String message) throws IOException {
        System.out.println("Received message: " + message);

        for (WebSocketSession session : myCustomWebSocketHandler.getSessions()) {
            if (session.isOpen()) {
                session.sendMessage(new TextMessage(message));
            }
        }
    }

}
