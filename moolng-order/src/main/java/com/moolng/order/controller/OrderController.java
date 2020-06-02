package com.moolng.order.controller;

import com.moolng.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/save")
    public String save(){
        orderService.saveOrder();
        return "ok";
    }

    @GetMapping(value = "/init")
    public String initDB(){
        orderService.initDB();
        return "ok";
    }

}
