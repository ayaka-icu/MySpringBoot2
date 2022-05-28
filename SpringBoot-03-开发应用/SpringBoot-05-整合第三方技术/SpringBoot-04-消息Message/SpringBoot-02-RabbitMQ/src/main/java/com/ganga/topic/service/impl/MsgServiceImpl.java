package com.ganga.topic.service.impl;


import com.ganga.topic.service.MsgTopicService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgServiceImpl implements MsgTopicService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMsg01(String uid) {
        System.out.println();
        System.out.println("正在放入消息队列 uid:" + uid);
        System.out.println("等待消息监听...");
        System.out.println();
        //放入消息队列
        amqpTemplate.convertAndSend("topicExchange","topic.user.xxx",uid);
    }

    @Override
    public void sendMsg02(String uid) {
        System.out.println();
        System.out.println("正在放入消息队列 uid:" + uid);
        System.out.println("等待消息监听...");
        System.out.println();
        //放入消息队列
        amqpTemplate.convertAndSend("topicExchange","xxx.xxx.uid",uid);
    }

    @Override
    public void sendMsg03(String uid) {
        System.out.println();
        System.out.println("正在放入消息队列 uid:" + uid);
        System.out.println("等待消息监听...");
        System.out.println();
        //放入消息队列
        amqpTemplate.convertAndSend("topicExchange","topic.user.uid",uid);
    }


}
