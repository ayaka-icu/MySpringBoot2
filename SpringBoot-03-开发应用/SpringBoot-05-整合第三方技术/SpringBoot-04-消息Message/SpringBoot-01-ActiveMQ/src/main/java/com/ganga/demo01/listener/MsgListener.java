package com.ganga.demo01.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MsgListener {

    /**
     * 监听处理消息
     * 并放入下一消息队列区域
     * @return
     */
    @JmsListener(destination = "order.msg.uid")
    @SendTo("order.msg.xxx.uid")
    public String receive(String uid){
        //处理消息逻辑...
        System.out.println();
        System.out.println("order.msg.uid");
        System.out.println("...已监听到该消息队列...");
        System.out.println("已从消息队列中获取 并 处理了消息...uid:"+uid);
        System.out.println("消息业务完成...uid:"+uid);
        System.out.println();
        return uid;
    }


    //监听 order。msg.xxx.uid
    @JmsListener(destination = "order.msg.xxx.uid")
    public void receiveX(String uid){
        //处理消息逻辑...
        System.out.println();
        System.out.println("order.msg.xxx.uid");
        System.out.println("...已监听到该消息队列...");
        System.out.println("已从消息队列中获取 并 处理了消息...uid:"+uid);
        System.out.println("消息业务完成...uid:"+uid);
        System.out.println();
    }

}
