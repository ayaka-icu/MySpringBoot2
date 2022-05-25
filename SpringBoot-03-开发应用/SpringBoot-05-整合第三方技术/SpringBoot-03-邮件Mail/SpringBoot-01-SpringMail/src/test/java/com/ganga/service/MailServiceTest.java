package com.ganga.service;

import com.ganga.mail.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    void send01(){
        String from = "xxxxxx@qq.com";
        String to = "xxxxxx@163.com";
        String subject = "文件标题";
        String text = "发送文件正文 -- 测试";

        mailService.sendMail(from,to,subject,text);
    }


    @Test
    void send02(){
        String from = "xxxxxx@qq.com"+"(这就尴尬了)";
        String to = "xxxxxx@qq.com";
        String subject = "文件标题subject";
        String text = "SpringBoot整合Mail 发送文件正文 -- 测试";

        mailService.sendMail(from,to,subject,text);
    }

}
