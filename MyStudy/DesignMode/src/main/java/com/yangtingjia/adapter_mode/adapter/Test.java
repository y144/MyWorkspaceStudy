package com.yangtingjia.adapter_mode.adapter;

import com.alibaba.fastjson.JSON;
import com.yangtingjia.adapter_mode.mq.CreateAccount;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;

/**
 * 杨廷甲
 * 2022-06-23
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        CreateAccount createAccount = new CreateAccount();

        createAccount.setNumber("1000001");
        createAccount.setAddress("河北省廊坊市光洋气");
        createAccount.setAccountDate(new Date());
        createAccount.setDesc("在校开户");

        HashMap<String,String> link01 = new HashMap<String,String>();
        link01.put("userId", "number");
        link01.put("bizId", "number");
        link01.put("bizTime", "accountDate");
        link01.put("desc", "desc");

        RebateInfo rebateInfo01 = MQAdapter.filter(createAccount.toString(), link01);
        System.out.println("mq.create_account(适配前)" + createAccount.toString());
        System.out.println("mq.create_account(适配后)" + JSON.toJSONString(rebateInfo01));

    }
}
