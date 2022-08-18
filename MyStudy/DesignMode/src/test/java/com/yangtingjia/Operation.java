package com.yangtingjia;

/**
 * 杨廷甲
 * 2022-06-28
 */
public enum Operation {
    ADD{
        @Override
        double apply(double x,double y) {
            return x + y;
        }
    },
    MINUS{
        @Override
        double apply(double x,double y) {
            return x - y;
        }
    },
    TIMES{
        @Override
        double apply(double x,double y) {
            return x * y;
        }
    },
    DEVIDE{
        @Override
        double apply(double x,double y) {
            return x / y;
        }
    };

    abstract double apply(double x,double y);

    public static void main(String[] args) {
        System.out.println(Operation.ADD.apply(5, 2));
    }
}
