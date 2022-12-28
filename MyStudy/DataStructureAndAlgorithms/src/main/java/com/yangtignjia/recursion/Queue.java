package com.yangtignjia.recursion;

import java.util.List;

/**
 * 杨廷甲
 * 2022-12-28
 */
public class Queue {

    static int count = 0;
    public static void main(String[] args) {
        //测试
        Queue queue = new Queue();
        queue.cheek(0);
        System.out.printf("一共有%d中解法" ,count);
    }

    //定义max表示一共有多少个皇后
    int max = 8;

    // 定义一个数组保存放置皇后位置的结果
    int[] array = new int[max];

    //方法 放置第n个皇后
    //特别注意：check方法是每一次递归时 进入到check中都有for (int i = 0; i < max; i++){} 因此会有回溯
    private void cheek(int n) {
        if (n == max) {
            // n=8 就说明其实 8 个皇后已经放好了
            print();
            return;
        }

        //依次放入皇后并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n放入改行的第一列
            array[n] = i;
            //判断当放置第n个皇后到i列时 是否冲突
            if (judge(n)) {
                //如果不冲突就接着放第n+1个皇后，即开始递归
                cheek(n+1);
            }
            //如果冲突 就继续执行array[n] = i 即第n个皇后 放置在本行的后移的一个位置
        }
    }

    /**
     * @param n 第n个皇后
     * @return
     */
    //方法 查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放好的皇后有冲突
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // array[i] == array[n] 如果第n个皇后与n -1个皇后在同一列
            // Math.abs(n - 1) == Math.abs(array[n] - array[i])判断第n个皇后是否和第i个皇后 在同一斜线上
            //没必要判断是否在同一行，n每次都在递增
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //方法 将皇后排放的位置输出
    private  void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
