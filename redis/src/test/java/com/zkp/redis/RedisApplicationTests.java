package com.zkp.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {


    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void Test() {

        redisTemplate.opsForValue().set("hhh","哈哈哈哈");
        redisTemplate.opsForValue().set("aaa","啊啊啊啊啊");

        Object aaa = redisTemplate.opsForValue().get("aaa");
        Object hhh = redisTemplate.opsForValue().get("hhh");

        System.out.println(aaa);
        System.out.println(hhh);
    }

}
