package com.yangtingjia.design_ruler.lishitihuan.improvement.goodfun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * 杨廷甲
 * 2022-07-02
 */
public class CreditCard extends CashCard {
    private Logger logger = LoggerFactory.getLogger(CreditCard.class);

    public CreditCard(String cardNo, String cardDate) {
        super(cardNo, cardDate);
    }

    boolean rule2(BigDecimal amount) {
        return amount.compareTo(new BigDecimal(1000)) <= 0;
    }

    /**
     * 提现，信用卡贷款
     * @param orderId
     * @param amount
     * @return
     */
    public String loan(String orderId,BigDecimal amount) {
        boolean rule = rule2(amount);

        if (!rule) {
            logger.info("生成贷款单失败，金额超限。单号：{} 金额：{}",orderId,amount);
            return "0001";
        }
        //模拟生成贷款
        logger.info("生成贷款单，单号：{} 金额：{}",orderId,amount);
        //模拟支付成功
        logger.info("贷款成功，单号：{} 金额：{}",orderId,amount);
        return super.negative(orderId, amount);

    }


    /**
     * 还款 信用卡还款
     * @param orderId
     * @param amount
     * @return
     */
    public String repayment(String orderId,BigDecimal amount) {
        //模拟生成还款单
        logger.info("生成还款单，单号：{} 金额：{}",orderId,amount);
        //模拟还款成功
        logger.info("还款成功，单号：{} 金额：{}",orderId,amount);
        return super.positive(orderId, amount);
    }

    /**
     * 信用卡类在继承了储蓄卡类之后，使用了公共的属性，即卡号 开卡时间 同时新增了符合信用卡功能的新方法，即贷款、还款，并在两个方法中都使用了抽象类的核心功能
     */
}
