package com.freecoder.config;

import com.freecoder.utils.MyWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @ClassName WebSocketConfig
 * @Description TODO
 * @DATE 2023/7/8 9:07
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myCustomWebSocketHandler(), "/websocket").setAllowedOrigins("*");
    }

    @Bean
    public MyWebSocketHandler myCustomWebSocketHandler() {
        return new MyWebSocketHandler();
    }

}
