package com.test;

import top.moxingwang.demo.springbootredis.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by MoXingwang on 2017/6/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class BaseTest {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Test
    public void test() {
        redisTemplate.opsForValue().set("mo123", "fsdfsd");

        String a = redisTemplate.opsForValue().get("mo123");

        System.out.println("");
    }
}
