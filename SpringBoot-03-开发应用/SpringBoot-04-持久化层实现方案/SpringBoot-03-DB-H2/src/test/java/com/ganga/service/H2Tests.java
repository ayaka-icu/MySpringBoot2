package com.ganga.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ganga.pojo.User;
import com.ganga.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class H2Tests {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void listTest(){
        List<User> list = userService.list();
        System.out.println(list);
    }

    @Test
    void updateByName(){
        userService.updateByName("尴尬",1);
        userService.updateByName("尴尬酱",2);
        userService.updateByName("SpringBoot",3);
    }

}
