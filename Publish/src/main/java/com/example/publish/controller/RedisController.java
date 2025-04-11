package com.example.publish.controller;

import com.example.publish.command.User;
import com.example.publish.component.RedisDatabaseSave;
import com.example.publish.component.RedisPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RedisController {

    @Autowired
    private RedisPublisher redisPublisher;

    @Autowired
    private RedisDatabaseSave redisDatabaseSave;

    //디비로 저장할때
    @PostMapping("/save")
    public String save(@RequestBody User user) {
        redisDatabaseSave.save(user);
        return "메시지 전송 완료!";
    }

    //디비에서 조회할때
    @GetMapping("/get")
    public User get(@RequestParam("id") String id) {
        return redisDatabaseSave.getUser(id);
    }

    //메시지로 저장할때
    @PostMapping("/send")
    public String send(@RequestBody String message) {
        redisPublisher.publish("example", message);
        return "메시지 전송 완료!";
    }
}
