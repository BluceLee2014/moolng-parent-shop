package com.moolng.tools.mq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQDelayListener {

    // queues是指要监听的队列的名字
    @RabbitListener(queues = "com.moolng.queue")
    public void receiveTopic1(String user) {
        System.out.println("【receiveFanout1监听到消息】" + user);
    }

}
