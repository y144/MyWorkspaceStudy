package com.yangtingjia.design_ruler.kaibi;

/**
 * 杨廷甲
 * 2022-07-02
 */
public interface ICalculationArea {

    /**
     * 计算面积，长方形
     * @param x 长
     * @param y 宽
     * @return 面积
     */
    double rectangle(double x,double y);


    /**
     * 计算三角形的面积
     * @param x 边长x
     * @param y 边长y
     * @param z 边长z
     * @return 面积
     * 海伦计算三角形的面积公式 S =
     */
    double triangle(double x,double y, double z);

    /**
     * 计算yuan的面积
     * @param r 半径
     * @return 面积
     */
    double circular(double r);
}
