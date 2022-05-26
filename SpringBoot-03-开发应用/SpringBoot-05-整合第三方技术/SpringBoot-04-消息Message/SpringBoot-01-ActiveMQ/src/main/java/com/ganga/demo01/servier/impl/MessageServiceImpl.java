package com.ganga.demo01.servier.impl;

import com.ganga.demo01.servier.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;


/**
 * 订单消息处理
 */
@Service
public class MessageServiceImpl implements MessageService {

    //注入 消息队列模板
    @Autowired
    private JmsMessagingTemplate messagingTemplate;

    /**
     * 获取待发送订单消息
     * 放入到消息队列当中
     * @param uid 订单
     */
    @Override
    public void sendMessage(String uid){
        //一些订单日志记录
        System.out.println("将订单消息放入消息队列 uid:" + uid);
        //放入消息队列
        messagingTemplate.convertAndSend("order.msg.uid",uid);
    }

    /**
     * 处理发送订单消息
     * 从消息队列中获取消息
     */
    /*@Override
    public String doMessage(){
        //从消息队列中获取消息
        String uid = messagingTemplate.receiveAndConvert(String.class);
        System.out.println("从模拟的消息队列中获取消息 uid:" + uid);
        System.out.println("完成信息发送业务...\t");
        return "完成信息发送业务";
    }*/

}
