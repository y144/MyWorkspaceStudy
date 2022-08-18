package com.yangtingjia.design_ruler.jiekougeli.improvement.impl;

import com.yangtingjia.design_ruler.jiekougeli.improvement.ISkillArchery;
import com.yangtingjia.design_ruler.jiekougeli.improvement.ISkillInvisible;
import com.yangtingjia.design_ruler.jiekougeli.improvement.ISkillSilent;

/**
 * 杨廷甲
 * 2022-07-03
 */
public class HeroHouYi implements ISkillArchery, ISkillInvisible, ISkillSilent {
    @Override
    public void doArchery() {
        System.out.println("后羿的灼日之矢");
    }

    @Override
    public void doInvisible() {
        System.out.println("后羿的隐身技能");
    }

    @Override
    public void doSilent() {
        System.out.println("后羿的沉默技能");
    }
}
