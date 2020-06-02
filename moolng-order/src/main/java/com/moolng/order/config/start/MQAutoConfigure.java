package com.moolng.order.config.start;

import com.moolng.tools.mq.rocketmq.ConsumerService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.rocketmq.client.exception.MQClientException;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.MybatisLanguageDriverAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
//@ConditionalOnClass(MQService.class)
//@EnableConfigurationProperties(MQServiceProperties.class)
@Configuration
@EnableConfigurationProperties(MQServiceProperties.class)
public class MQAutoConfigure {

//    @Autowired
//    MQServiceProperties mqServiceProperties;
//
//    @Bean
//    @ConditionalOnMissingBean
//    @ConditionalOnProperty(prefix = "moolng.mq", value = "openConsumer", havingValue = "true")
//    MQService mqService (){
//        System.out.println("启动mqService");
//        if(mqServiceProperties.isOpenConsumer()){
//            System.out.println("==============> mqService");
//            new Thread(()->{
//                try {
//                    ConsumerService producerService = new ConsumerService();
//                    System.out.println("启动 : " + System.currentTimeMillis());
//                    producerService.send();
//                } catch (MQClientException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
//        return new MQService(mqServiceProperties.isOpenConsumer());
//    }

    public MQAutoConfigure(MQServiceProperties properties) {
        System.out.println("启动");
        System.out.println(properties.isOpenConsumer());
        if (properties.isOpenConsumer()) {
            System.out.println("==============> MQAutoConfigure init");
            new Thread(() -> {
                System.out.println("==============> MQAutoConfigure Thread lading...");
                MQConsumerServer2 mqConsumerServer = new MQConsumerServer2();
                try {
                    mqConsumerServer.getMsg();
                } catch (MQClientException e) {
                    e.printStackTrace();
                }
//                try {
//                    ConsumerService producerService = new ConsumerService();
//                    System.out.println("启动 : " + System.currentTimeMillis());
//                    producerService.send();
//                } catch (MQClientException e) {
//                    e.printStackTrace();
//                }
            }).start();
        }
    }

}
