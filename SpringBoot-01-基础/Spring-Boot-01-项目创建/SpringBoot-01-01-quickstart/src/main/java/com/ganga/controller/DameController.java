package com.ganga.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//Rest风格编程
@RestController()
@RequestMapping("/dame")
public class DameController {

    @GetMapping("/me")
    @ResponseBody
    public String me(){
        System.out.println("SpringBoot ruing ......");
        return "SpringBoot ruing ......";
    }
}
