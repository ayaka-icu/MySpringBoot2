package com.ganga.topic.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserMsgListener {

    @RabbitListener(queues = "topic_queue_uid")
    public void userMsgListener(String uid) {
        String name = Thread.currentThread().getName() + " : ";
        //处理消息逻辑...
        System.out.println();
        System.out.println(name + "----- topic_queue_uid ------");
        System.out.println(name + "------- 已监听 监听器001 -------");
        System.out.println(name + "已从消息队列中获取 并 处理了消息...uid:" + uid);
        System.out.println(name + "业务AAAAAAA完成...uid:" + uid);
        System.out.println();
    }

    @RabbitListener(queues = "topic_queue2_uid")
    public void userMsgListener2(String uid) {
        String name = Thread.currentThread().getName() + " : ";
        //处理消息逻辑...
        System.out.println();
        System.out.println(name + "----- topic_queue2_uid ------");
        System.out.println(name + "------- 已监听 监听器001 -------");
        System.out.println(name + "已从消息队列中获取 并 处理了消息...uid:" + uid);
        System.out.println(name + "业务BBBBBBB完成...uid:" + uid);
    }


}
