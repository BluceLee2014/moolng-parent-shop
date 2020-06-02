package com.moolng.order.service.impl;

import com.moolng.order.MoolngOrderApplication;
import com.moolng.order.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MoolngOrderApplication.class)
public class OrderServiceImplTest {

    @Autowired
    OrderService orderService;

    @Test
    public void saveIntegral() {
        orderService.saveOrder();
    }
}