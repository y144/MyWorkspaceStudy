package com.yangtingjia.design_ruler.danyi.improvement.impl;

import com.yangtingjia.design_ruler.danyi.improvement.IVideoUserService;

/**
 * 杨廷甲
 * 2022-07-02
 */
public class GuestVideoUserService implements IVideoUserService {
    @Override
    public void definition() {
        System.out.println("访客用户 视屏的清晰度为480p");
    }

    @Override
    public void advertisement() {
        System.out.println("访客用户，视屏有广告");
    }
}
