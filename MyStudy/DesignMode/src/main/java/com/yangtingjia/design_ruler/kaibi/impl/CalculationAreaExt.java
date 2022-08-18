package com.yangtingjia.design_ruler.kaibi.impl;

/**
 * 杨廷甲
 * 2022-07-02
 */
public class CalculationAreaExt extends CalculationAreaImpl {
    private final static double n = 3.1415926D;

    @Override
    public double circular(double r) {
        return n * r * r;
    }

    /**
     * 按照开闭的原则方式实现起来并不复杂，它的主要的目的是不能因为个例需求的变变化而改变预定的实现类，除非预定的实现类有错误
     * 实现过程是继承父类扩展需要的方法，同时可以保留原来的方法，新增自己需要的方法
     */
}
