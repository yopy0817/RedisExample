package com.example.publish.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    //디비기능을 사용할 때
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory); // Redis 서버와 연결하기 위한 커넥션 팩토리 설정

        template.setKeySerializer(new StringRedisSerializer()); // Redis의 Key를 문자열로 직렬화 (예: "USER")
        template.setHashKeySerializer(new StringRedisSerializer()); // Hash 타입에서 Hash의 Key를 문자열로 직렬화 (예: "userId")
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer()); // Hash 타입에서 Hash의 Value를 JSON 형식으로 직렬화 (객체 -> JSON 문자열)

        return template;
    }
}
