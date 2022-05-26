package com.ganga.servier.impl;

import com.ganga.servier.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 订单消息处理
 */
@Service
public class MessageServiceImpl implements MessageService {

    //模拟一个消息队列
    private ArrayList<String> mockMQ = new ArrayList<>();

    /**
     * 获取待发送订单消息
     * 放入到消息队列当中
     * @param uid 订单
     */
    @Override
    public void sendMessage(String uid){
        //一些订单日志记录
        System.out.println("将订单消息放入到模拟的消息队列 uid:" + uid + "\t");
        mockMQ.add(uid);
    }

    /**
     * 处理发送订单消息
     * 从消息队列中获取消息
     */
    @Override
    public String doMessage(){
        //从消息队列中获取消息
        String uid = mockMQ.get(0);
        System.out.println("从模拟的消息队列中获取消息 uid:" + uid);
        System.out.println("完成信息发送业务...\t");
        return "完成信息发送业务";
    }

}
