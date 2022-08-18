package com.yangtingjia.adapter_mode.design_no_service;

import com.alibaba.fastjson.JSON;
import com.yangtingjia.adapter_mode.mq.POPOrderDelivered;

import java.math.BigDecimal;

/**
 * 杨廷甲
 * 2022-06-23
 */
public class POPOrderDeliveredService {

    public void onMessage(String message) {
        POPOrderDelivered mq = JSON.parseObject(message, POPOrderDelivered.class);

        BigDecimal money = mq.getDecimal();

        System.out.println(money);
    }
}
