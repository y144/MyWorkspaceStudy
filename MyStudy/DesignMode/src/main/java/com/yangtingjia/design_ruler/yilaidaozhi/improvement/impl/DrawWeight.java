package com.yangtingjia.design_ruler.yilaidaozhi.improvement.impl;

import com.yangtingjia.design_ruler.yilaidaozhi.improvement.IDraw;
import com.yangtingjia.design_ruler.yilaidaozhi.origin.BetUser;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨廷甲
 * 2022-07-03
 */
public class DrawWeight implements IDraw {


    @Override
    public List<BetUser> prize(List<BetUser> list, int count) {
        //按照权重排序
        list.sort((o1, o2) -> {
            int e = o2.getUserWeight() - o1.getUserWeight();
            if (0 == e) return 0;
            return e > 0 ? 1 : -1;
        });

        //取出指定数量的中奖用户
        List<BetUser> prizeList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            prizeList.add(list.get(i));
        }
        return prizeList;
    }
}
