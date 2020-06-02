package com.moolng.integral.service.impl;

import com.moolng.integral.MoolngIntegralApplication;
import com.moolng.integral.service.IntegralService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MoolngIntegralApplication.class)
public class IntegralServiceImplTest {

    @Autowired
    IntegralService integralService;

    @Test
    public void saveIntegral() {
        integralService.saveIntegral();
    }
}