package com.yangtingjia.design_ruler.lishitihuan.improvement.goodfun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 杨廷甲
 * 2022-07-02
 */
public abstract class BackCard {

    /**
     * 在抽象银行卡类中，提供了基本卡的属性，包括卡号、开卡时间、及三个核心方法。
     * 正向入账 加钱
     * 逆向入账 减钱
     * 查询交易流水
     */

    private Logger logger = LoggerFactory.getLogger(BackCard.class);

    private String cardNo; //卡号

    private String cardDate; //开卡时间

    public BackCard(String cardNo, String cardDate) {
        this.cardNo = cardNo;
        this.cardDate = cardDate;
    }

    //规则
    abstract boolean rule(BigDecimal amount);

    /**
     * 正向入账，加钱
     * @param orderId
     * @param amount
     * @return
     */
    public String positive(String orderId,BigDecimal amount) {
        //入款成功 存款、还款
        logger.info("卡号() 入款成功，单号：{} 金额:{}" ,cardNo,orderId,amount);
        return "0000";
    }

    public String negative(String orderId,BigDecimal amount){
        //出款成功，存款 还款
        logger.info("卡号() 出款成功，单号：{} 金额：{}" ,cardNo,orderId,amount);
        return "0000";
    }

    /**
     * 交易流水查询
     * @return
     */
    public List<String> tradeFlow(){
        logger.info("交易流水查询成功");
        List<String> tradeList = new ArrayList<>();
        tradeList.add("100001,100.00");
        tradeList.add("100001,80.00");
        tradeList.add("100001,76.00");
        tradeList.add("100001,126.00");
        return tradeList;
    }

    public String getCardNo(){
        return cardNo;
    }

    public String getCardDate(){
        return cardDate;
    }
}
