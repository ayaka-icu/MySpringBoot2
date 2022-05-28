package com.ganga.direct.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class MsgListener {

    /**
     * 监听 queues={"",""} 消息队列中的消息
     * @param uid
     */
    @RabbitListener(queues = {"simple_direct_uid"})
    public void msgListener(String uid){
        //处理消息逻辑...
        System.out.println();
        System.out.println("----- simple_direct_uid ------");
        System.out.println("------- 已监听 监听器001 -------");
        System.out.println("已从消息队列中获取 并 处理了消息...uid:"+uid);
        System.out.println("消息业务完成...uid:"+uid);
        System.out.println();
    }

    /**
     * 监听 queues={"",""} 消息队列中的消息
     * @param uid
     */
    @RabbitListener(queues = {"simple_direct_uid"})
    public void msgListener2(String uid){
        //处理消息逻辑...
        System.out.println();
        System.out.println("----- simple_direct_uid ------");
        System.out.println("------- 已监听 监听器002 -------");
        System.out.println("已从消息队列中获取 并 处理了消息...uid:"+uid);
        System.out.println("消息业务完成...uid:"+uid);
        System.out.println();
    }
    //使用多消息监听器对消息队列监听进行消息轮循处理(direct)
    /** 两个监听器同时监听一个消息队列
     *  直连模式 DirectExchange模式下  交替使用
     *
     * 正在放入消息队列 uid:AAA
     * 等待消息监听...
     *
     *
     * ----- simple_direct_uid ------
     * ------- 已监听 监听器002 -------
     * 已从消息队列中获取 并 处理了消息...uid:AAA
     * 消息业务完成...uid:AAA
     *
     * 正在放入消息队列 uid:BBB
     * 等待消息监听...
     *
     *
     * ----- simple_direct_uid ------
     * ------- 已监听 监听器001 -------
     * 已从消息队列中获取 并 处理了消息...uid:BBB
     * 消息业务完成...uid:BBB
     *
     * 正在放入消息队列 uid:CCC
     * 等待消息监听...
     *
     *
     * ----- simple_direct_uid ------
     * ------- 已监听 监听器002 -------
     * 已从消息队列中获取 并 处理了消息...uid:CCC
     * 消息业务完成...uid:CCC
     *
     * 正在放入消息队列 uid:DDD
     * 等待消息监听...
     *
     *
     * ----- simple_direct_uid ------
     * ------- 已监听 监听器001 -------
     * 已从消息队列中获取 并 处理了消息...uid:DDD
     * 消息业务完成...uid:DDD
     */

}
