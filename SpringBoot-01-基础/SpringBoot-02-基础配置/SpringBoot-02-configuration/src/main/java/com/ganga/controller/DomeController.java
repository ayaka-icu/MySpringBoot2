package com.ganga.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dome")
public class DomeController {

    @GetMapping
    public String dome01(){
        return "访问成功....";
    }

}
