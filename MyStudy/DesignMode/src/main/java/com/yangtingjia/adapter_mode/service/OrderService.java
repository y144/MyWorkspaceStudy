package com.yangtingjia.adapter_mode.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 杨廷甲
 * 2022-06-23
 */
//这个接口主要用于查询用户在内部商家的下单数量
public class OrderService {
    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    public long queryUserOrderCount(String userId) {
        logger.info("内部商家，查询用户的下单数量：{}",userId);
        return 10L;
    }
}
