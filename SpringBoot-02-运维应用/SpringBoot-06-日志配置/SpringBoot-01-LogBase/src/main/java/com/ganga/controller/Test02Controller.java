package com.ganga.controller;

import com.ganga.controller.utils.BaseClass;
import com.ganga.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test02")
public class Test02Controller extends BaseClass {

    @Autowired
    private TestDao testDao;

    //http://localhost/test02/run
    @RequestMapping("/run")
    @ResponseBody
    public String me(){
        System.out.println("SpringBoot2...");
        System.out.println("========Test02=========");

        //记录日志
        log.trace("trace...");//最低级别, 一般没人用
        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.debug("debug...");
        log.error("error..."); //高级别
        //log.fatal(); //灾难性级别 理论上记录 springboot将其融入到了error级别

        testDao.me();

        return "SpringBoot2...";
    }

}