package com.ganga.controller;

import com.ganga.servier.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 获取订单
     */
    @PostMapping("{uid}")
    public String doOrder(@PathVariable String uid){
        //处理订单并发送消息
        orderService.doOrder(uid);
        return "订单已处理";
    }

}
