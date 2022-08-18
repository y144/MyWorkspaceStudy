package com.yangtingjia.adapter_mode.mq;

import java.util.Date;
import java.util.Objects;

/**
 * 杨廷甲
 * 2022-06-23
 */
//注册开户MQ 消息体
public class CreateAccount {
    private String number; // 开户编号
    private String address; // 开户地
    private Date accountDate; //开户时间
    private String desc; //开户描述

    @Override
    public String toString() {
        return "CreateAccount{" +
                "number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", accountDate=" + accountDate +
                ", desc='" + desc + '\'' +
                '}';
    }

    public CreateAccount() {
    }

    public CreateAccount(String number, String address, Date accountDate, String desc) {
        this.number = number;
        this.address = address;
        this.accountDate = accountDate;
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateAccount that = (CreateAccount) o;
        return Objects.equals(number, that.number) &&
                Objects.equals(address, that.address) &&
                Objects.equals(accountDate, that.accountDate) &&
                Objects.equals(desc, that.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, address, accountDate, desc);
    }

    public String getNumber() {
        return number;
    }

    public CreateAccount setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CreateAccount setAddress(String address) {
        this.address = address;
        return this;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public CreateAccount setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public CreateAccount setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
