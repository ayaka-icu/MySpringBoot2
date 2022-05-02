package com.ganga.controller;

import com.alibaba.fastjson.JSON;
import com.ganga.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/users01")
public class UserController01 {

    @RequestMapping("/save")
    @ResponseBody
    public String save(){
        System.out.println("book save... ");
        return "{\"module\":\"user save\"}";
    }

    //http://localhost:8080/users01/delete?id=1
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id){
        System.out.println("book save... " + id);
        return "{\"module\":\"user delete\"}";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody User user){
        System.out.println("book save... " + user);
        return "{\"module\":\"user update\"}";
    }

    @RequestMapping("/getById")
    @ResponseBody
    public String getById(Integer id){
        System.out.println("book save... " + id);
        return "{\"module\":\"user getById\"}";
    }

}
