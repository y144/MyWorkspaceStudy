package com.yangtingjia.adapter_mode.adapter;

import java.util.Date;

/**
 * 杨廷甲
 * 2022-06-23
 */
public class RebateInfo {
    private String userId; //用户id
    private String bizId; //业务id
    private Date bizTime; //业务时间
    private String desc; //业务描述

    public String getUserId() {
        return userId;
    }

    public RebateInfo setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getBizId() {
        return bizId;
    }

    public RebateInfo setBizId(String bizId) {
        this.bizId = bizId;
        return this;
    }

    public Date getBizTime() {
        return bizTime;
    }

    public RebateInfo setBizTime(Date bizTime) {
        this.bizTime = bizTime;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public RebateInfo setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
