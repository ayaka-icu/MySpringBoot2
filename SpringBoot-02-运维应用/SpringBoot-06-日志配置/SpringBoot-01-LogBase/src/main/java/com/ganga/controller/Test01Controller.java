package com.ganga.controller;

import com.ganga.dao.TestDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test01")
public class Test01Controller {

    //创建记录日志的对象
    private static final Logger log = LoggerFactory.getLogger(Test01Controller.class);

    @Autowired
    private TestDao testDao;

    //http://localhost/test01/run
    @RequestMapping("/run")
    @ResponseBody
    public String me(){
        System.out.println("SpringBoot2...");
        System.out.println("========Test01=========");

        //记录日志
        log.trace("trace...");//最低级别, 一般没人用
        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.debug("debug...");
        log.error("error..."); //高级别
        //log.fatal(); //灾难性级别 理论上记录 springboot将其融入到了error级别

        //启用那个等级的日志 ，就会记录那个级别 及其 更高级别的日志

        //默认级别是 INFO 级别
        //SpringBoot2...
        //2022-05-11 16:03:58.760  INFO 13912 --- [p-nio-80-exec-4] com.ganga.controller.Test01Controller    : info...
        //2022-05-11 16:03:58.760  WARN 13912 --- [p-nio-80-exec-4] com.ganga.controller.Test01Controller    : warn...
        //2022-05-11 16:03:58.760 ERROR 13912 --- [p-nio-80-exec-4] com.ganga.controller.Test01Controller    : error...

        testDao.me();

        return "SpringBoot2...";
    }

}
