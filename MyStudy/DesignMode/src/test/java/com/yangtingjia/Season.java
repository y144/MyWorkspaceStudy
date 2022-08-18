package com.yangtingjia;

/**
 * 杨廷甲
 * 2022-06-28
 */
public enum Season {
    SPRING(20.1), SUMMER(36.5), AUTUMN(12.5), WINTER(0.3);

    //每个季节的平均温度
    private double averageTem;

    /**
     * 它的每一个数据 都是一个对象了。一种数据类型
     * 构造方法
     * @param averageTem
     */
    Season(double averageTem) {
        this.averageTem = averageTem;
    }

    /**
     * 提供一个get 方法返回数据
     * @return
     */
    public double getAverageTem(){
        return averageTem;
    }

    public static void main(String[] args) {
        System.out.println(Season.valueOf("SPRING").getAverageTem());
    }

}


