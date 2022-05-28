package com.ganga.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 类前@RocketMQMessageListener() 必要的两个参数 topic consumerGroup
 *      topic消息的key 也就是要监听那个消息
 *      consumerGroup指定那个组中的消息
 *
 * 该类实现 RocketMQListener<>接口
 *      泛型是该消息的类型
 *      实现的方法
 *          参数是 消息内容
 *          方法体 具体要消费消息的业务逻辑
 *
 */
@Component //topic消息的key  consumerGroup指定那个组中的消息
@RocketMQMessageListener(topic = "order_msg_uid",consumerGroup = "order_user")
public class MsgListener implements RocketMQListener<String> {

    /**
     * 参数类型 --> 实现RocketMQListener<>的泛型
     * uid 是消息的
     * @param uid
     */
    @Override
    public void onMessage(String uid) {

        System.out.println("----- 消息已监听 ------");
        System.out.println("已从消息队列中获取 并 处理了消息...uid:" + uid);
        System.out.println("消息业务完成...uid:" + uid);
        System.out.println();
    }
}
