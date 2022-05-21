package com.ganga.controller;

import com.ganga.pojo.MsgCode;
import com.ganga.server.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private MsgService msgService;

    @GetMapping("/{tal}")
    public String get(@PathVariable String tal){
        String msg = msgService.getAndSave(tal);
        return "验证码为: " + msg;
    }

    @PostMapping
    public String check(@RequestBody MsgCode msgCode){
        boolean check = msgService.check(msgCode);
        if (check){
            return "验证成功！";
        }
        return "验证码失败！";
    }

}
