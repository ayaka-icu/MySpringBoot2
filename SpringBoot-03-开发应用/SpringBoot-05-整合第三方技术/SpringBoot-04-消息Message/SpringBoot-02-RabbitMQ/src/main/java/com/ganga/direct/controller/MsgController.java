package com.ganga.direct.controller;

import com.ganga.direct.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/direct/msg")
public class MsgController {

    @Autowired
    private MsgService msgService;

    @PostMapping("{uid}")
    public String sendMessage(@PathVariable String uid){
        msgService.sendMsg(uid);
        return "消息发送成功...订单号:"+uid;
    }

}
