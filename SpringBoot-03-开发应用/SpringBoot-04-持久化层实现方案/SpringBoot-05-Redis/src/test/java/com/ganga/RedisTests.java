package com.ganga;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class RedisTests {

    /**
     * 注入 RedisTemplate 对象
     */
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void setTest() {
        //opsFor...() 选择要操作的方式
        ValueOperations operations = redisTemplate.opsForValue();
        operations.set("my_name","尴尬酱");
    }

    @Test
    void getTest(){
        ValueOperations operations = redisTemplate.opsForValue();
        Object myName = operations.get("my_name");
        System.out.println(myName);
    }


    @Test
    void hsetTest(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("stu1","name","尴尬酱");
        hashOperations.put("stu1","age",9);
        hashOperations.put("stu1","hobby","动漫");
    }

    @Test
    void hgetTest(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        Object obj1 = hashOperations.get("stu1", "name");
        Object obj2 = hashOperations.get("stu1", "age");
        Object obj3 = hashOperations.get("stu1", "hobby");
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);
    }



}
