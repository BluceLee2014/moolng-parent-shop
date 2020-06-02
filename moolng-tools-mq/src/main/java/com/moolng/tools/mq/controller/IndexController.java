package com.moolng.tools.mq.controller;

import com.moolng.tools.mq.service.RabbitMQServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private RabbitMQServcie rabbitMQServcie;

    @GetMapping("/sendMsg")
    public String sendMsg(int delayTime){
        rabbitMQServcie.sendMsg(delayTime);
        return "ok";
    }

}
