package com.yangtingjia.adapter_mode.design_no_service;

import com.alibaba.fastjson.JSON;
import com.yangtingjia.adapter_mode.mq.CreateAccount;

import java.util.Date;

/**
 * 杨廷甲
 * 2022-06-23
 */
public class CreateAccountMqService {

    public void onMessage(String message) {
        CreateAccount mq = JSON.parseObject(message, CreateAccount.class);
        String number = mq.getNumber();
        Date accountDate = mq.getAccountDate();

        System.out.printf("%s%s%n", number, accountDate);
    }
}
