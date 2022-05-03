package com.ganga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EnvironmentController {

    /**
     * SpringBoot 封装了所有的数据
     *  通过注入Environment对象
     *  的getProperty()方法获取相应的数据
     *      getProperty()方法的参数是就是
     *      之前写的el表达式"${user.age}" 去掉${}后的内容
     *      "${a.b1.c.d.e1}" ---> "a.b1.c.d.e1"
     *      "${likes1[0]}"   ---> "likes1[0]"
     *      ......
     */
    @Autowired
    private Environment env;

    //注入yaml数据 使用SpEL表达式
    /*@Value("${user.age}")
    private Integer age;
    @Value("${a.b1.c.d.e1}")
    private String e1;
    @Value("${a.b2.c.d.x}")
    private String x;
    @Value("${likes1[0]}")
    private String likes01;
    @Value("${timeDir}")
    private String timeDir;
    @Value("${timeDirT}")
    private String timeDirT;*/

    //http://localhost:9999/env
    @RequestMapping(value = "/env",produces = "text/html;charset=utf8")
    @ResponseBody
    public String yamlTest(){
        String str = "<h3 align=\"center\"> Environment... <br>";
        str += "age ===> " + env.getProperty("user.age") + "<br>";
        str += "e1 ===> " + env.getProperty("a.b1.c.d.e1") + "<br>";
        str += "x ===> " + env.getProperty("a.b2.c.d.x") + "<br>";
        str += "likes01 ===> " + env.getProperty("likes1[0]") + "<br>";
        str += "timeDir ===> " + env.getProperty("timeDir") + "<br>";
        str += "timeDirT ===> " + env.getProperty("timeDirT") + "<br>";

        str += "</h3>";
        return str;
    }


}
