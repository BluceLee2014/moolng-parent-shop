package com.moolng.integral.controller;

import com.moolng.integral.service.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/integral")
public class IntegralController {

    @Autowired
    IntegralService integralService;

    @PostMapping(value = "/save")
    public String save(){
        integralService.saveIntegral();
        return "ok";
    }


}
