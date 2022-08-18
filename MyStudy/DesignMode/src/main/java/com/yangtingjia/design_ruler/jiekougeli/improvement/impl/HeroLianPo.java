package com.yangtingjia.design_ruler.jiekougeli.improvement.impl;

import com.yangtingjia.design_ruler.jiekougeli.improvement.ISkillInvisible;
import com.yangtingjia.design_ruler.jiekougeli.improvement.ISkillSilent;
import com.yangtingjia.design_ruler.jiekougeli.improvement.ISkillVertigo;

/**
 * 杨廷甲
 * 2022-07-03
 */
public class HeroLianPo implements ISkillInvisible, ISkillSilent, ISkillVertigo {
    @Override
    public void doInvisible() {
        System.out.println("廉颇的隐身技能");
    }

    @Override
    public void doSilent() {
        System.out.println("廉颇的沉默技能");
    }

    @Override
    public void doVertigo() {
        System.out.println("廉颇的眩晕技能");
    }

    /**
     * 现在可以看到这两个英雄的类都按照自己需要的实现接口技能
     * 提高了代码的维护性，可靠性
     */
}
