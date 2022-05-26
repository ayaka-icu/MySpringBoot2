package com.ganga.demo02.service.impl;

import com.ganga.demo02.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private JmsMessagingTemplate messagingTemplate;

    @Override
    public void sendMsg(String uid) {

        System.out.println("正在放入消息队列 uid:" + uid);
        System.out.println("等待消息监听...");
        System.out.println();
        //放入消息队列
        messagingTemplate.convertAndSend("msg.service.uid",uid);

    }


    /**
     * 监听处理消息
     * 并放入下一消息队列区域
     * @return
     */
    @JmsListener(destination = "msg.service.uid")
    @SendTo(value = "msg.service.x1.uid")
    public String doMsg01(String uid) {

        //处理消息逻辑...
        System.out.println();
        System.out.println("msg.service.uid");
        System.out.println("...已监听到该消息队列...");
        System.out.println("已从消息队列中获取 并 处理了消息...uid:"+uid);
        System.out.println("消息业务完成...uid:"+uid);
        System.out.println();

        return uid;//返回的这个参数 就是放入下一消息区域的消息
    }

    @JmsListener(destination = "msg.service.x1.uid")
    public void doMsg02(String uid){
        //处理消息逻辑...
        System.out.println();
        System.out.println("msg.service.x1.uid");
        System.out.println("...已监听到该消息队列...");
        System.out.println("已从消息队列中获取 并 处理了消息...uid:"+uid);
        System.out.println("消息业务完成...uid:"+uid);
        System.out.println();
    }

}
