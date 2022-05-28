package com.ganga.topic.controller;

import com.ganga.direct.service.MsgService;
import com.ganga.topic.service.MsgTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topic/msg")
public class MsgController {

    @Autowired
    private MsgTopicService msgTopicService;

    @PostMapping("{uid}")
    public String sendMessage(@PathVariable String uid){
        msgTopicService.sendMsg01(uid);
        return "消息发送成功...订单号:"+uid;
    }

    /**
     * 正在放入消息队列 uid:AAA
     * 等待消息监听...
     *
     *
     * org.springframework.amqp.rabbit.RabbitListenerEndpointContainer#1-1 : ----- topic_queue_uid ------
     * org.springframework.amqp.rabbit.RabbitListenerEndpointContainer#1-1 : ------- 已监听 监听器001 -------
     * org.springframework.amqp.rabbit.RabbitListenerEndpointContainer#1-1 : 已从消息队列中获取 并 处理了消息...uid:AAA
     * org.springframework.amqp.rabbit.RabbitListenerEndpointContainer#1-1 : 业务AAAAAAA完成...uid:AAA
     *
     */

    @GetMapping("{uid}")
    public String sendMessage2(@PathVariable String uid){
        msgTopicService.sendMsg02(uid);
        return "消息发送成功...订单号:"+uid;
    }

    /**
     * 正在放入消息队列 uid:AAA
     * 等待消息监听...
     *
     *
     * org.springframework.amqp.rabbit.RabbitListenerEndpointContainer#0-1 : ----- topic_queue2_uid ------
     * org.springframework.amqp.rabbit.RabbitListenerEndpointContainer#0-1 : ------- 已监听 监听器001 -------
     * org.springframework.amqp.rabbit.RabbitListenerEndpointContainer#0-1 : 已从消息队列中获取 并 处理了消息...uid:AAA
     * org.springframework.amqp.rabbit.RabbitListenerEndpointContainer#0-1 : 业务BBBBBBB完成...uid:AAA
     *
     */


    @PutMapping("{uid}")
    public String sendMessage3(@PathVariable String uid){
        msgTopicService.sendMsg03(uid);
        return "消息发送成功...订单号:"+uid;
    }
    /**
     *org.springframework.amqp.rabbit.RabbitListenerEndpointContainer#1-1 : ----- topic_queue_uid ------
     * org.springframework.amqp.rabbit.RabbitListenerEndpointContainer#1-1 : ------- 已监听 监听器001 -------
     *
     * org.springframework.amqp.rabbit.RabbitListenerEndpointContainer#1-1 : 已从消息队列中获取 并 处理了消息...uid:XXX
     * org.springframework.amqp.rabbit.RabbitListenerEndpointContainer#1-1 : 业务AAAAAAA完成...uid:XXX
     *
     * org.springframework.amqp.rabbit.RabbitListenerEndpointContainer#0-1 : ----- topic_queue2_uid ------
     * org.springframework.amqp.rabbit.RabbitListenerEndpointContainer#0-1 : ------- 已监听 监听器001 -------
     * org.springframework.amqp.rabbit.RabbitListenerEndpointContainer#0-1 : 已从消息队列中获取 并 处理了消息...uid:XXX
     * org.springframework.amqp.rabbit.RabbitListenerEndpointContainer#0-1 : 业务BBBBBBB完成...uid:XXX
     */

}
