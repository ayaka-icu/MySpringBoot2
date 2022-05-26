package com.ganga.servier.impl;

import com.ganga.servier.MessageService;
import com.ganga.servier.OrderService;
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
        messageService.sendMessage(uid);//处理消息

        System.out.println("订单业务结束...");
        System.out.println();
    }

}
