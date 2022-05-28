package com.ganga.direct.service.impl;

import com.ganga.direct.service.MsgService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMsg(String uid) {

        System.out.println("正在放入消息队列 uid:" + uid);
        System.out.println("等待消息监听...");
        System.out.println();
        //放入消息队列
        amqpTemplate.convertAndSend("directExchange","direct",uid);
    }

}
