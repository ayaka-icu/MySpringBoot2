package com.ganga.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class YamlController {

    //注入yaml数据 使用SpEL表达式
    @Value("${user.age}")
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
    private String timeDirT;


    //http://localhost:9999/yaml
    @RequestMapping(value = "/yaml",produces = "text/html;charset=utf8")
    @ResponseBody
    public String yamlTest(){
        String str = "<h3 align=\"center\">";
        str += "age ===> " + age + "<br>";
        str += "e1 ===> " + e1 + "<br>";
        str += "x ===> " + x + "<br>";
        str += "likes01 ===> " + likes01 + "<br>";
        str += "timeDir ===> " + timeDir + "<br>";
        str += "timeDirT ===> " + timeDirT + "<br>";

        str += "</h3>";
        return str;
    }

}
