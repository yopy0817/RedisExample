package com.example.subscribe.component;


import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class RedisSubscriber implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = new String(pattern);
        String body = new String(message.getBody(), StandardCharsets.UTF_8);
        System.out.println("📥 Redis 메시지 수신 [" + channel + "] : " + body);
    }
}
