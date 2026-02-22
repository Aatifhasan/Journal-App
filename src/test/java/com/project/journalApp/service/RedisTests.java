package com.project.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
//        redisTemplate.opsForValue().set("email","aatifhasan00@gmail.com");
        Object salary=redisTemplate.opsForValue().get("salary");
          int a=1;
    }

}
