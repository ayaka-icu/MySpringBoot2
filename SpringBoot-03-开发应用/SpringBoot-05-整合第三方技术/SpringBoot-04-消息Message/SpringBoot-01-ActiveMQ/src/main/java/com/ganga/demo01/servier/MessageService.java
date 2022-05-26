package com.ganga.demo01.servier;

/**
 * 订单消息处理
 */
public interface MessageService {

    /**
     * 获取待发送订单消息
     * 放入到消息队列当中
     * @param uid 订单
     */
    void sendMessage(String uid);

    /**
     * 处理发送订单消息
     * 从消息队列中获取消息
     */
    /*String doMessage();*/

}
