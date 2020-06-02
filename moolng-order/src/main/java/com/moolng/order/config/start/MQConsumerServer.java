package com.moolng.order.config.start;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.client.QueryResult;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class MQConsumerServer {

    private final String GROUP_NAME = "consumer_demo";
    private final String NAMESRV_ADDR = "127.0.0.1:9876";
    private DefaultMQPushConsumer consumer;

    public MQConsumerServer() {
        try {
            this.consumer = new DefaultMQPushConsumer(GROUP_NAME);
            this.consumer.setNamesrvAddr(NAMESRV_ADDR);
            this.consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
            this.consumer.subscribe("TopicTest", "*");
            this.consumer.registerMessageListener(new Listener());
            this.consumer.start();
            System.out.println("consumer start");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public QueryResult queryMessage(String topic, String key, int maxNum, long begin, long end) throws Exception {
        long current = System.currentTimeMillis();
        return this.consumer.queryMessage(topic, key, maxNum, begin, end);
    }

    class Listener implements MessageListenerConcurrently {
        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
            MessageExt msg = msgs.get(0);
            try {
                String topic = msg.getTopic();
                System.out.println(topic);
                System.out.println(msg);
                //Message Body
//                JSONObject messageBody = FastJsonConvert.convertJSONToObject(new String(msg.getBody(), "utf-8"), JSONObject.class);
//                String tags = msg.getTags();
//                String keys = msg.getKeys();
//
//                System.out.println("服务收到消息, keys : " + keys + ", body : " + new String(msg.getBody(), "utf-8"));
//                long userid = messageBody.getLong("userid");
//                String face = messageBody.getString("face"); //头像
//                String trueName = messageBody.getString("truename"); //姓名
//                int gender = messageBody.getInteger("gender"); //性别
//                int workClass = messageBody.getInteger("workClass"); //期望职位ID
//                int workCity = messageBody.getInteger("workCity");
//                User user = new User();
//                user.setUserId(userid);
//                user.setFace(face);
//                user.setTruename(trueName);
//                user.setGender(gender);
//                user.setStep(4);
//                updateUserService.updateUserInfo(user);



            } catch (Exception e) {
                e.printStackTrace();
                //重试次数为3情况
                if(msg.getReconsumeTimes() == 3){
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    //记录日志
                }
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
    }
}
