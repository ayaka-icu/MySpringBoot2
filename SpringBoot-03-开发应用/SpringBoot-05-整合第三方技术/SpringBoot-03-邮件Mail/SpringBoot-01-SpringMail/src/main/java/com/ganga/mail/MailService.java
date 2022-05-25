package com.ganga.mail;

public interface MailService {

    /**
     * 发送消息
     * @param from 消息来源
     * @param to   消息目标
     * @param subject 消息标题
     * @param text    消息正文
     */
    void sendMail(String from, String to, String subject, String text);

}
