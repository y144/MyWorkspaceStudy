package com.yangtingjia.adapter_mode.mq;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 杨廷甲
 * 2022-06-23
 */
//第三方订单MQ 消息体
public class POPOrderDelivered {
    private String uId; //用户id
    private String orderId; //订单号
    private Date orderTime; //下单时间
    private Date sku; //商品编号
    private Date skuName; //商品名称
    private BigDecimal decimal; //商品金额

    public String getuId() {
        return uId;
    }

    public POPOrderDelivered setuId(String uId) {
        this.uId = uId;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public POPOrderDelivered setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public POPOrderDelivered setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public Date getSku() {
        return sku;
    }

    public POPOrderDelivered setSku(Date sku) {
        this.sku = sku;
        return this;
    }

    public Date getSkuName() {
        return skuName;
    }

    public POPOrderDelivered setSkuName(Date skuName) {
        this.skuName = skuName;
        return this;
    }

    public BigDecimal getDecimal() {
        return decimal;
    }

    public POPOrderDelivered setDecimal(BigDecimal decimal) {
        this.decimal = decimal;
        return this;
    }
}
