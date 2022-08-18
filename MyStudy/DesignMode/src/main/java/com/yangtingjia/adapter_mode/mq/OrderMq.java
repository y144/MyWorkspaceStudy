package com.yangtingjia.adapter_mode.mq;

import java.util.Date;

/**
 * 杨廷甲
 * 2022-06-23
 */
//内部订单MQ 消息体
public class OrderMq {
    private String uId; //用户id
    private String sku; //商品编号
    private String orderId; //订单id
    private Date createOrderDate; //下单时间

    public String getuId() {
        return uId;
    }

    public OrderMq setuId(String uId) {
        this.uId = uId;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public OrderMq setSku(String sku) {
        this.sku = sku;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderMq setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public Date getCreateOrderDate() {
        return createOrderDate;
    }

    public OrderMq setCreateOrderDate(Date createOrderDate) {
        this.createOrderDate = createOrderDate;
        return this;
    }
}
