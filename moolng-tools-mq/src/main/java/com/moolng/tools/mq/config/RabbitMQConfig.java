package com.moolng.tools.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {

    String q1 = "com.moolng.delay.queue";
    String q2 = "com.moolng.queue";
    String e1 = "com.moolng.exchange";
    String r1 = "com.moolng.routing.key";

// String name, boolean durable, boolean exclusive, boolean autoDelete,
//			@Nullable Map<String, Object> arguments
    @Bean
    public Queue comMoolngDelayQueue(){
        Map<String, Object> arguments = new HashMap<String, Object>();
        arguments.put("x-dead-letter-exchange", e1);
        arguments.put("x-dead-letter-routing-key", r1);
        return new Queue(q1, true, false, false, arguments);
    }

    @Bean
    public Queue comMoolngQueue(){
        return new Queue(q2, true, false, false, null);
    }

    @Bean
    public DirectExchange comMoolngExchange(){
       return new DirectExchange (e1);

    }

    @Bean
    public Binding myBinding(){
        return BindingBuilder.bind(comMoolngQueue()).to(comMoolngExchange()).with(r1);
    }


}
