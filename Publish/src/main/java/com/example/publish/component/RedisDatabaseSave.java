package com.example.publish.component;

import com.example.publish.command.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class RedisDatabaseSave {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations<String, String, Object> hashOperations;

    @PostConstruct //의존성 주입이 일어난 이후에 초기화 진행
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    //레디스 저장기능
    public void save(User user) {
        hashOperations.put("USER", user.getId() , user);
    }
    
    //레디스 조회
    public User getUser(String userId) {
        return (User)hashOperations.get("USER", userId); //없으면 null반환
    }
    


}
