package com.yangtingjia.design_ruler.jiekougeli.origin.impl;

import com.yangtingjia.design_ruler.jiekougeli.origin.ISkill;

/**
 * 杨廷甲
 * 2022-07-03
 */
public class HeroHouYi implements ISkill {
    @Override
    public void doArchery() {
        System.out.println("后羿的灼日之矢");
    }

    @Override
    public void doInvisible() {
        System.out.println("后羿的隐身技能");
    }

    @Override
    public void doSlicent() {
        System.out.println("后羿的沉默技能");
    }

    @Override
    public void doVertigo() {
        //无此技能
    }
}
