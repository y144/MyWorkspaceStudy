package com.yangtingjia.adapter_mode.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 杨廷甲
 * 2022-06-23
 */
//此接口主要用于查询第三方订单是否为首单
public class POPOrderService {
    private static Logger logger = LoggerFactory.getLogger(POPOrderService.class);

    public boolean isFirstOrder(String uid) {
        logger.info("POP商家，查询用户的订单是否为首单：{}",uid);
        return true;
    }
}
