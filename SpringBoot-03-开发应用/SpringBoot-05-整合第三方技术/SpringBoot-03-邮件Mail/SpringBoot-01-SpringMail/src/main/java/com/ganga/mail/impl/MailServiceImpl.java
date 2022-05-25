package com.ganga.mail.impl;

import com.ganga.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    //注入邮箱发送对象
    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 发送消息
     * @param from 消息来源
     * @param to   消息目标
     * @param subject 消息标题
     * @param text    消息正文
     */
    @Override
    public void sendMail(String from, String to, String subject, String text) {

        //发送简单的消息
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        javaMailSender.send(message);
    }

    //https://gitee.com/embarrassing-sauce/my-code/raw/master/img/Ximg/imgs.jpg





}
