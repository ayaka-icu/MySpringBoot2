package com.ganga;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class StringRedisTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void setTest(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("尴尬了","尴尬");
    }

    @Test
    void getTest(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String s1 = ops.get("mylist");
        String s2 = ops.get("尴尬了");
        System.out.println(s1);
        System.out.println(s2);
    }

}
