package com.ganga.demo01.controller;


import com.ganga.demo01.servier.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msg")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /*@GetMapping
    public String sendMessage(){
        String str = messageService.doMessage();
        return str;
    }*/

}
