package com.yangtingjia.design_ruler.danyi.improvement.impl;

/**
 * 杨廷甲
 * 2022-07-02
 */
public class DanyiTest {
    public static void main(String[] args) {

        /**
         * 利用单一原则优化后的代码，现在每个类都只负责自己的用户的行为，后续如果无论扩展新 的功能呢还是需要在某个时刻修改用户的某个行为，都可以非常方便的开发
         * 在项目的开发中尽可能的保证接口的定义、类的实现与以及方法的开发保持单一职责。
         */

        //访客用户
        GuestVideoUserService guestVideoUserService = new GuestVideoUserService();
        guestVideoUserService.definition();
        guestVideoUserService.advertisement();

        //普通会员
        OrdinaryVideoUserService ordinary = new OrdinaryVideoUserService();
        ordinary.advertisement();
        ordinary.definition();

        //vip用户
         VipVideoUserService vip = new VipVideoUserService();
         vip.advertisement();
         vip.definition();
         vip.danmu();
    }
}
