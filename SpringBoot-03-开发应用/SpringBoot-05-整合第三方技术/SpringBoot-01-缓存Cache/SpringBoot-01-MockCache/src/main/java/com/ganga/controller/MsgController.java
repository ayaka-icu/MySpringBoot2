package com.ganga.controller;

import com.ganga.server.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private MsgService msgService;

    @GetMapping("/{tal}")
    public String get(@PathVariable Long tal){
        int msg = msgService.getAndSave(tal);
        return "验证码为: " + msg;
    }

    @GetMapping("/{tal}/{code}")
    public String get(@PathVariable Long tal, @PathVariable int code){
        boolean check = msgService.check(tal, code);
        if (check){
            return "验证成功！";
        }
        return "验证码失败！";
    }

}
