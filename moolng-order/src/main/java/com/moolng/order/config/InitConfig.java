package com.moolng.order.config;

import com.moolng.tools.mq.rocketmq.ConsumerService;
import com.moolng.tools.mq.rocketmq.ProducerService;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@Configurable
public class InitConfig {

//    @Autowired
//    ;

    @Bean(value = "consumerService")
    public ConsumerService getConsumerService(){
        return new ConsumerService();
    }

    @PostConstruct
    public void initPro(){
        System.out.println("启动");
//        new Thread(()->{
//            try {
//                ConsumerService producerService = new ConsumerService();
//                System.out.println("启动 : " + System.currentTimeMillis());
//                producerService.send();
//            } catch (MQClientException e) {
//                e.printStackTrace();
//            }
//        }).start();
    }


}
