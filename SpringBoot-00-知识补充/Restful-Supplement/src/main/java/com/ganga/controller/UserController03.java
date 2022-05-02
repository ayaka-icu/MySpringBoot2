package com.ganga.controller;

import com.ganga.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody
@RestController //@Controller + @ResponseBody

@RequestMapping("/users")
public class UserController03 {

    //restful风格 添加create --> POST
    @PostMapping
    public String create(@RequestBody User user){ //add
        System.out.println("me:create新增" + " 参数:" + user);
        return "{\"module\":\"user create\"}";
    }

    //Restful风格 删除delete --> DELETE
    @DeleteMapping("/{id}")
    public String delete(/*指定使用路径参数*/@PathVariable Integer id){
        System.out.println("me:delete删除" + " 参数:" + id);
        return "{\"module\":\"user delete\"}";
    }

    //Restful风格 修改update --> PUT
    @PutMapping
    public String update(@RequestBody User user){
        System.out.println("me:update修改" + " 参数:" + user);
        return "{\"module\":\"user update\"}";
    }

    //Restful风格 查询select --> GET
    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println("me:getById查询" + " 参数:" + id);
        return "{\"module\":\"user getById\"}";
    }

}
