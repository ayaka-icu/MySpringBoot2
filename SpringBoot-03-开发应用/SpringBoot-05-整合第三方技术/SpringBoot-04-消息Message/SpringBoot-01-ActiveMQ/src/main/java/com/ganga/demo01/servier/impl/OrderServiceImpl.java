package com.ganga.demo01.servier.impl;


import com.ganga.demo01.servier.MessageService;
import com.ganga.demo01.servier.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MessageService messageService;

    /**
     * 订单业务
     * @param uid
     */
    @Override
    public void doOrder(String uid) {

        //订单日志...
        System.out.println("订单业务开始...");
        //各种业务逻辑的调用...
        System.out.println("订单业务结束...");

        //发消息业务
        messageService.sendMessage(uid);//处理消息
    }

}
