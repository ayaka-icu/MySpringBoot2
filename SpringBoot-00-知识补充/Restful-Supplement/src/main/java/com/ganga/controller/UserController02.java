package com.ganga.controller;

import com.ganga.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users02")
public class UserController02 {

    //restful风格 添加create --> POST
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody User user){ //add
        System.out.println("me:create新增" + " 参数:" + user);
        return "{\"module\":\"user create\"}";
    }

    //Restful风格 删除delete --> DELETE
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(/*指定使用路径参数*/@PathVariable Integer id){
        System.out.println("me:delete删除" + " 参数:" + id);
        return "{\"module\":\"user delete\"}";
    }

    //Restful风格 修改update --> PUT
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody User user){
        System.out.println("me:update修改" + " 参数:" + user);
        return "{\"module\":\"user update\"}";
    }

    //Restful风格 查询select --> GET
    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getById(@PathVariable Integer id){
        System.out.println("me:getById查询" + " 参数:" + id);
        return "{\"module\":\"user getById\"}";
    }

}
