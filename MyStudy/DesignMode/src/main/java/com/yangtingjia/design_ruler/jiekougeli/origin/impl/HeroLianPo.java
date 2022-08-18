package com.yangtingjia.design_ruler.jiekougeli.origin.impl;

import com.yangtingjia.design_ruler.jiekougeli.origin.ISkill;

/**
 * 杨廷甲
 * 2022-07-03
 */
public class HeroLianPo implements ISkill {
    @Override
    public void doArchery() {
        //无此技能
    }

    @Override
    public void doInvisible() {
        System.out.println("廉颇的隐身技能");
    }

    @Override
    public void doSlicent() {
        System.out.println("廉颇的沉默技能");
    }

    @Override
    public void doVertigo() {
        System.out.println("廉颇的眩晕技能");
    }

    /**
     * 综上
     * 每个英雄的实现都有一个与自己无关的接口实现，非常不符合设计模式，也不易于维护，因为不仅无法控制外部的调用，还需要维护对应的文档，来说明这个接口不需要实现，如果有更多的接口就会很麻烦
     */
}
