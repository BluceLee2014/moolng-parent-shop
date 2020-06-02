package com.moolng.order.config.start;

import io.swagger.models.auth.In;
import org.apache.rocketmq.client.QueryResult;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class MQConsumerServer2 {

    private final String GROUP_NAME = "consumer_demo";
    private final String NAMESRV_ADDR = "127.0.0.1:9876";
    private DefaultMQPushConsumer consumer;

    public MQConsumerServer2() {

    }

    public void getMsg() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(GROUP_NAME);
        consumer.setNamesrvAddr(NAMESRV_ADDR);
        consumer.subscribe("TopicTest", "*");

        consumer.registerMessageListener(new MessageListenerConcurrently() {

            public ConsumeConcurrentlyStatus consumeMessage(final List<MessageExt> msgs,
                                                            final ConsumeConcurrentlyContext context) {
                for(int i=0; i<msgs.size(); i++) {
                    MessageExt msg = msgs.get(i);
                    String str = new String(msg.getBody());
                    System.out.println(msg);
                    String[] strs = str.split(",");
                    Integer id = Integer.valueOf(strs[1]);
                    System.out.println("=== [" + msg.getMsgId() + "]" + str);
                    System.out.println(id%2);
                    if(id%2 != 0){
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                    }
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }
}
