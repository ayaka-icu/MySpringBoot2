package com.ganga;

import com.ganga.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * SpringBoot~整合Junit
 */
//第一步: 注解@SpringBootTest 指定classes配置引导类
@SpringBootTest()
class SpringBootJunitTest {

    //第二步: 注入需要测试的类对象
    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        userDao.save();
    }

}
