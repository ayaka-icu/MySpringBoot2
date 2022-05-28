package com.ganga.service.impl;

import com.ganga.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MsgServiceImpl implements MsgService {

    //注入 KafkaTemplate 对象
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    /**
     * 异步消息
     * @param uid
     */
    @Override
    public void sendMsg(String uid) {

        System.out.println("正在放入消息队列 uid:" + uid);
        System.out.println("等待消息监听...");
        System.out.println();

        //放入消息队列
        kafkaTemplate.send("order_topic_uid",uid);
    }

}
