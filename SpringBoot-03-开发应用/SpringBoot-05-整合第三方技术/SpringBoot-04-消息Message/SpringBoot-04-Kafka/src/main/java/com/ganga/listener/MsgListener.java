package com.ganga.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MsgListener {

    /**
     * 使用@KafkaListener 至少指定一个 topics 确定监听的哪个消息
     *
     * @param consumerRecord 参数需要一个 ConsumerRecord 可以获取信息的各种 参数 和 值
     */
    @KafkaListener(topics = {"order_topic_uid"})
    public void onMessage(ConsumerRecord<String,String> consumerRecord){

        //获取消息的内容
        String uid = consumerRecord.value();
        System.out.println(consumerRecord.timestamp());

        System.out.println("----- 消息已监听 ------");
        System.out.println("已从消息队列中获取 并 处理了消息...uid:" + uid);
        System.out.println("消息业务完成...uid:" + uid);
        System.out.println();

    }

}
