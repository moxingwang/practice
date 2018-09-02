package top.moxingwang.demo.springbootredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by MoXingwang on 2017/6/5.
 */
@RestController
@RequestMapping(value = "test")
public class TestController {
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public String test() {
        redisTemplate.opsForValue().set("mo123", UUID.randomUUID().toString());
        String test = redisTemplate.opsForValue().get("mo123");
        return test;
    }
}
