package com.project.product.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.UUID;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<UUID, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<UUID, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }


}
