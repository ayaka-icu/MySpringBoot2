package com.ganga.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

    public static final Logger log = LoggerFactory.getLogger(TestDao.class);

    //测试
    public void me(){
        System.out.println("=======================");
        System.out.println("=====com.ganga.dao=====");
        //记录日志
        log.trace("trace...");//最低级别, 一般没人用
        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.debug("debug...");
        log.error("error..."); //高级别
        System.out.println("=======================");
    }

}
