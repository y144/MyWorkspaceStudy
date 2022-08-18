package com.yangtingjia.design_ruler.kaibi.impl;

import com.yangtingjia.design_ruler.kaibi.ICalculationArea;

/**
 * 杨廷甲
 * 2022-07-02
 */
public class CalculationAreaImpl implements ICalculationArea {

    public static final double n = 3.14D;
    //public static final double n = 3.1415926D;
    //如果不考虑开闭原则，直接去修改n的值，基本可以满足需求但是因为精度加长 而破坏了原有精度下的稳定性

    @Override
    public double rectangle(double x, double y) {
        return x * y;
    }

    @Override
    public double triangle(double x, double y, double z) {
        double p = (x + y + z) / 2;
        return Math.sqrt(p * (p - x) * (p - y) * (p - z));
    }

    @Override
    public double circular(double r) {
        return n * r * r;
    }
}
