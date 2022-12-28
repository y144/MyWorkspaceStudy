package com.yangtignjia.recursion;

/**
 * 杨廷甲
 * 2022-12-28
 */
public class RecursionTest {
    public static void main(String[] args) {

        //通过打印问题回顾递归
        test(4);

        //阶乘问题
        System.out.println(factorial(5));
    }


    /**
     * 打印 问题
     * @param n
     */
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n = " + n);
    }

    /**
     * 阶乘问题
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n==1) {
            return 1;
        }else {
            return factorial(n - 1) * n;
        }
    }
}
