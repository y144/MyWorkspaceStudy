package com.yangtingjia.design_ruler.lishitihuan.origin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

/**
 * 杨廷甲
 * 2022-07-02
 */
public class CreditCard extends CashCard {
    private Logger logger = LoggerFactory.getLogger(CreditCard.class);

    /**
     * 贷款功能
     * @param orderId 单号
     * @param amount  金额
     * @return
     */
    @Override
    public String withdrawal(String orderId, BigDecimal amount) {
        //校验参数
        if (amount.compareTo(new BigDecimal(1000)) >= 0) {
            logger.info("贷款金额校验（限额1000元），单号：{} 金额：{}",orderId,amount);
            return "0001";
        }

        //模拟生成贷款单
        logger.info("生成贷款单，单号：{} 金额：{}",orderId,amount);
        //模拟支付成功
        logger.info("贷款成功，单号：{} 金额：{}" ,orderId,amount);
        return "0000";
    }

    /**
     * 还款功能
     * @param orderId 单号
     * @param amount  金额
     * @return
     */
    @Override
    public String recharge(String orderId, BigDecimal amount) {
        //模拟生成还款单
        logger.info("生成还款单，单号：{} 金额：{}" ,orderId,amount);
        //模拟还款成功
        logger.info("还款成功，订单号：{} 金额：{}",orderId,amount);
        return "0000";
    }

    /**
     * 打印信用卡流水详情
     * @return
     */
    @Override
    public List<String> tradeFlow() {
        return super.tradeFlow();
    }

    /**
     * 信用卡功能呢的实现是在继承了储蓄卡的类之后，进行方法的重写：支付方法，还款方法，打印流水方法
     * 其实也可以不用重写这个方法，可以复用
     */
}
