package com.yangtingjia.adapter_mode.adapter;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * 杨廷甲
 * 2022-06-23
 */
//消息统一适配类

/**
 *这个类里的方法很重要
 * 主要用于把不同类型的mq 中的不同的属性映射成为需要的属性并返回
 * uId --> userId
  */
public class MQAdapter {

    public static RebateInfo filter(String strJson, Map<String,String> link)throws NoSuchMethodException, InvocationTargetException,IllegalAccessException {
        return filter(JSON.parseObject(strJson, Map.class), link);
    }

    public static RebateInfo filter(Map obj,Map<String,String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RebateInfo rebateInfo = new RebateInfo();

        for (String key : link.keySet()) {
            Object val = obj.get(link.get(key));
            RebateInfo.class.getMethod("set" + key.substring(0,1).toUpperCase() + key.substring(1),String.class).invoke(rebateInfo, val.toString());
        }
        return rebateInfo;
    }
}
