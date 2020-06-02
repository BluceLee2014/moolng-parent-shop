package com.moolng.integral.service.impl;

import com.moolng.integral.mapper.IntegralMapper;
import com.moolng.integral.service.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegralServiceImpl implements IntegralService {

    @Autowired
    IntegralMapper integralMapper;

    @Override
    public void saveIntegral() {
        integralMapper.saveIntegral();
    }
}
