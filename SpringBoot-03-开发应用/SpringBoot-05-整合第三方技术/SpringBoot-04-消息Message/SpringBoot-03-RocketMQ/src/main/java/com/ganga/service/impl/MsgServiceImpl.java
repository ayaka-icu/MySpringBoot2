package com.ganga.service.impl;

import com.ganga.service.MsgService;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 同步消息
     */
    /*@Override
    public void sendMsg(String uid) {

        System.out.println("正在放入消息队列 uid:" + uid);
        System.out.println("等待消息监听...");
        System.out.println();

        //放入消息队列
        rocketMQTemplate.convertAndSend("order_msg_uid",uid);
    }*/


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
        SendCallback message = new SendCallback() {
            @Override //消息成功放入队列后的回调函数
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息 [成功] 放入队列后的回调函数...");
            }
            @Override //消息失败放入队列后的回调函数
            public void onException(Throwable throwable) {
                System.out.println("消息 [失败] 放入队列后的回调函数...");
            }
        };
        rocketMQTemplate.asyncSend("order_msg_uid",uid,message);

    }

}
