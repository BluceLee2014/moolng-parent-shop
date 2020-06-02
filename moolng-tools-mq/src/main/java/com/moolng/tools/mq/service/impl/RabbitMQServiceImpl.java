package com.moolng.tools.mq.service.impl;

import com.moolng.tools.mq.service.RabbitMQServcie;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServiceImpl implements RabbitMQServcie {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMsg(final int delayTime) {
        String msg = "hello word " + System.currentTimeMillis();
        rabbitTemplate.convertAndSend("", "com.moolng.delay.queue", msg, new MessagePostProcessor(){

            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                MessageProperties messageProperties = message.getMessageProperties();
//                messageProperties.setDelay(delayTime);
                messageProperties.setExpiration((delayTime*1000)+"");
                return message;
            }
        }, null);
    }
}
