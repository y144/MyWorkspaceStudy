package com.yangtingjia.design_ruler.danyi.improvement.impl;

import com.yangtingjia.design_ruler.danyi.improvement.IVideoUserService;

/**
 * 杨廷甲
 * 2022-07-02
 */
public class VipVideoUserService implements IVideoUserService {
    @Override
    public void definition() {
        System.out.println("VIP用户，视屏清晰度1080p");
    }

    @Override
    public void advertisement() {
        System.out.println("vip用户 无广告");
    }

    public void danmu(){
        System.out.println("这个是VIP用户自己特有的功能，发送弹幕");
    }

    /**
     *
     * 综上 每种用户对应的服务队友对应的类的实现，互相不会干扰，当某一类用户需要添加新的运营规则时操作起来也非常方便
     */
}
