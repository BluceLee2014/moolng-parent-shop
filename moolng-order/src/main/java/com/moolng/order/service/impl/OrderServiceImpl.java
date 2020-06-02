package com.moolng.order.service.impl;

import com.moolng.order.dto.UserDTO;
import com.moolng.order.mapper.OrderMapper;
import com.moolng.order.service.OrderService;
import com.moolng.tools.mq.rocketmq.ConsumerService;
import com.moolng.tools.mq.rocketmq.ProducerService;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

//    @Autowired
//    ConsumerService consumerService;

    @Override
    public void saveOrder() {
        orderMapper.saveOrder();
//        try {
////            consumerService.send();
//        } catch (MQClientException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void initDB() {
        UserDTO dto = null;
        List<UserDTO> userList = null;
        for(int i=0;i<10000;i++){
            userList = new ArrayList<>(1000);
            for(int j=0;j<1000;j++){
                dto = new UserDTO();
                String userName = this.getCharAndNumr(10);
                dto.setUserName(userName);
                dto.setEmail(userName + "@163.com");
                dto.setPassword(this.getCharAndNumr(6));
                userList.add(dto);
            }
            orderMapper.initDB(userList);
        }
    }


    public String getCharAndNumr(int length) {

        Random random = new Random();

        StringBuffer valSb = new StringBuffer();

        String charStr = "0123456789abcdefghijklmnopqrstuvwxyz";

        int charLength = charStr.length();



        for (int i = 0; i < length; i++) {

            int index = random.nextInt(charLength);

            valSb.append(charStr.charAt(index));

        }

        return valSb.toString();

    }
}
