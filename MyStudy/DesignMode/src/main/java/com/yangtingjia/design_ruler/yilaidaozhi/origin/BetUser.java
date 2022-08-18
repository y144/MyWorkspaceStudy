package com.yangtingjia.design_ruler.yilaidaozhi.origin;

/**
 * 杨廷甲
 * 2022-07-03
 */
public class BetUser {
    /**
     * 这个类方便满足不同的抽奖方式
     */
    private String userName; //用户名
    private int userWeight; //用户权重

    public String getUserName() {
        return userName;
    }

    public BetUser setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public int getUserWeight() {
        return userWeight;
    }

    public BetUser setUserWeight(int userWeight) {
        this.userWeight = userWeight;
        return this;
    }
}
