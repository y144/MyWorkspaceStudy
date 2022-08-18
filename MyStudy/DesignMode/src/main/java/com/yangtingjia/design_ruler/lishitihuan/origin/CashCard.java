package com.yangtingjia.design_ruler.lishitihuan.origin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 杨廷甲
 * 2022-07-02
 */
public class CashCard {

    /**
     * 在储蓄卡的功能实现中包括了三个方法：提现、储蓄、交易流水查询，这些都是模拟储蓄卡的基本功能
     */

    public Logger logger = LoggerFactory.getLogger(CashCard.class);

    /**
     * 提现
     * @param orderId 单号
     * @param amount 金额
     * @return 状态码 0000成功 0001 失败 0002 重复
     */
    public String withdrawal(String orderId, BigDecimal amount) {
        //模拟支付成功
        logger.info("提现成功，单号：{} 金额：{}",orderId,amount);
        return "0000";
    }


    /**
     * 储蓄
     * @param orderId 单号
     * @param amount 金额
     * @return 状态码
     */
    public String recharge(String orderId,BigDecimal amount) {
        //模拟充值功能
        logger.info("储蓄成功，单号：{} 金额：{}",orderId,amount);
        return "0000";
    }

    /**
     * 交易流水查询
     * @return
     */
    public List<String> tradeFlow() {
        logger.info("交易流水查询成功");
        List<String> tradeList = new ArrayList<>();
        tradeList.add("100001,100.00");
        tradeList.add("100001,80.00");
        tradeList.add("100001,76.00");
        tradeList.add("100001,126.00");
        return tradeList;
    }


}
