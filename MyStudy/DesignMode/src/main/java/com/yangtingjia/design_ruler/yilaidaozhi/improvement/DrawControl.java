package com.yangtingjia.design_ruler.yilaidaozhi.improvement;

import com.yangtingjia.design_ruler.yilaidaozhi.origin.BetUser;

import java.util.List;

/**
 * 杨廷甲
 * 2022-07-03
 */
public class DrawControl {
    private IDraw draw;

    public List<BetUser> doDraw(IDraw draw,List<BetUser> betUserList, int count) {
        return draw.prize(betUserList, count);
    }

    /**
     * 这个类体现了依赖倒置的重要性，可以吧任何一种抽象逻辑传递给这个类
     * 这样实现的好处是可以不断的扩展，但是不需要在外部新增调用接口，降低了一套代码的维护成本
     *
     * 另外 这里的重点是吧实现逻辑的接口作为参数传递，在一些源码框架中经常会有这样的操作
     */
}
