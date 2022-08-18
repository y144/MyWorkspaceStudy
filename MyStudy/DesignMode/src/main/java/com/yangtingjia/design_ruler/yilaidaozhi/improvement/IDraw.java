package com.yangtingjia.design_ruler.yilaidaozhi.improvement;

import com.yangtingjia.design_ruler.yilaidaozhi.origin.BetUser;

import java.util.List;

/**
 * 杨廷甲
 * 2022-07-03
 */
public interface IDraw {
    //获取中奖用户接口
    List<BetUser> prize(List<BetUser> list, int count);
}
