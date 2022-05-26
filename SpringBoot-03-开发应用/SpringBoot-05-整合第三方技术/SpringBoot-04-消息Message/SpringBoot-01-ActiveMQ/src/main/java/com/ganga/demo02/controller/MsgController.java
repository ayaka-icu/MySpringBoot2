package com.ganga.demo02.controller;

import com.ganga.demo02.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/msg")
public class MsgController {

    @Autowired
    private MsgService msgService;

    @PostMapping("{uid}")
    public String sendMessage(@PathVariable String uid){
        msgService.sendMsg(uid);
        return "消息发送成功...订单号:"+uid;
    }

}
