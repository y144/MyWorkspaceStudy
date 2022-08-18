package com.yangtingjia.design_ruler.lishitihuan.improvement.goodfun;

import java.math.BigDecimal;

/**
 * 杨廷甲
 * 2022-07-02
 */
public class BackTest {
    public static void main(String[] args) {
        CashCard backCard = new CashCard("966356985233366", "2022-02-22");

        //提现
        backCard.withdrawal("100001", new BigDecimal(100));

        //储存
        backCard.recharge("100001", new BigDecimal(100));
    }
}
