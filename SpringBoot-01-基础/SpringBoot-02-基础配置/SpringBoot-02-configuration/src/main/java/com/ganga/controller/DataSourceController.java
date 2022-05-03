package com.ganga.controller;

import com.ganga.config.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataSourceController {

    /**
     * 注入演示加载 yaml文件中的数据 是否成功
     */
    @Autowired
    private MyDataSource myDataSource;

    //http://localhost:9999/data
    @RequestMapping(value = "/data",produces = "text/html;charset=utf8")
    @ResponseBody
    public String yamlTest(){
        String str = myDataSource.toString();
        System.out.println(str);
        return str;
    }


}
