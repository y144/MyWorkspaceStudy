package com.yangtingjia.design_ruler.danyi.improvement.impl;

import com.yangtingjia.design_ruler.danyi.improvement.IVideoUserService;

/**
 * 杨廷甲
 * 2022-07-02
 */
public class OrdinaryVideoUserService implements IVideoUserService {
    @Override
    public void definition() {
        System.out.println("普通会员，视屏清清晰度720p");
    }

    @Override
    public void advertisement() {
        System.out.println("普通会员，播放视屏有广告");

    }
}
