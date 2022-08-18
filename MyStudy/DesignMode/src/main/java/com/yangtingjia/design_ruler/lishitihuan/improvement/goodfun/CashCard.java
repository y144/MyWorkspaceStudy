package com.yangtingjia.design_ruler.lishitihuan.improvement.goodfun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * 杨廷甲
 * 2022-07-02
 */
public class CashCard extends BackCard {

    private Logger logger = LoggerFactory.getLogger(CashCard.class);

    public CashCard(String cardNo, String cardDate) {
        super(cardNo, cardDate);
    }

    /**
     * 规则过滤，储蓄卡直接默认通过
     * @param amount
     * @return
     */
    @Override
    boolean rule(BigDecimal amount) {
        return true;
    }

    /**
     * 提现
     * @param orderId
     * @param amount
     * @return
     */
    public String withdrawal(String orderId,BigDecimal amount) {
        //模拟支付成功
        logger.info("模拟体现成功，单号：{} 金额：{}" ,orderId,amount);
        return super.negative(orderId,amount);
    }

    /**
     * 储蓄
     * @param orderId
     * @param amount
     * @return
     */
    public String recharge(String orderId,BigDecimal amount) {
        //模拟储蓄成功
        logger.info("储蓄成功，订单号：{} 金额：{}",orderId,amount);
        return super.positive(orderId, amount);
    }

    /**
     * 功能增强  风险校验
     * @param cardNo 卡号
     * @param orderId 单号
     * @param amount 金额
     * @return 状态
     */
    public boolean checkRisk(String cardNo,String orderId,BigDecimal amount){
        //模拟风控校验
        logger.info("风控校验，卡号{} 单号：{} 金额：{}",cardNo,orderId,amount);
        return true;
    }

    /**
     * 这样的实现方式基本满足了里氏替换原则的基本的原则，既实现抽象类的抽象方法，又没有破坏父类中原有的方法
     */

}
