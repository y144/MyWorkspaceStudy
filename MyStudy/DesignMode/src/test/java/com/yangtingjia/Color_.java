package com.yangtingjia;

/**
 * 杨廷甲
 * 2022-06-28
 */
public enum  Color_ implements IColor {

    RED, GREEN, BLANK, YELLOW;

    @Override
    public String toString(){
        return "color:" + super.toString();
    }


    @Override
    public int getColorIndex() {
        return this.ordinal(); //ordinal()方法 是返回枚举数据的排序下标从0开始，按顺序递增
    }

    public static void main(String[] args) {
        System.out.println("GREEN的下标是："+Color_.GREEN.getColorIndex() + "\nYELLOW的下标是：" +Color_.YELLOW.getColorIndex());
    }
}

interface IColor{
    int getColorIndex();
}
