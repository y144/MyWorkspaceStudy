package com.yangtingjia.design_ruler.jiekougeli.origin;

/**
 * 杨廷甲
 * 2022-07-03
 */
public interface ISkill {
    //射箭
    void doArchery();

    //影袭
    void doInvisible();

    //沉默
    void doSlicent();

    //眩晕
    void doVertigo();

    /**
     * 王者荣耀里有很多英雄，可以分为射手、战士、刺客等，每个英雄有三种技能，这些技能应该如何定义，让每个英雄实现相应的技能效果
     * 以后羿和廉颇为例
     */
}
