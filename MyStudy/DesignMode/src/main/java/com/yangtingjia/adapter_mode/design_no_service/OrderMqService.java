package com.yangtingjia.adapter_mode.design_no_service;

import com.alibaba.fastjson.JSON;
import com.yangtingjia.adapter_mode.mq.OrderMq;
import com.yangtingjia.adapter_mode.service.OrderService;

import java.util.Date;

/**
 * 杨廷甲
 * 2022-06-23
 */
public class OrderMqService {
    public void onMessage(String message) {
        OrderMq mq = JSON.parseObject(message, OrderMq.class);

        Date createOrderDate = mq.getCreateOrderDate();

        System.out.println(createOrderDate.toString());
    }
}
