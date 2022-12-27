package com.yangtignjia.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 杨廷甲
 * 2022-12-27
 */
public class PolandNotation {
    public static void main(String[] args) {
        //先定义一个逆波兰表达式 (3+4) * 5 -6 --> 3 4 + 5 * 6 -
        //说明 为了方便 逆波兰表达式中的数字与符号用空格隔开
        String suffixExpression = "3 4 + 5 * 6 -";
        //1.先将suffixExpression 放入到arrayList中
        //2.将arrayList传递给一个方法，这个方法中遍历arrayList配合栈完成计算
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList = " + rpnList);

    }

    //将这个逆波兰表达式依次将数据和运算符放入arrayList中
    public static List<String> getListString(String suffixExpression) {
        // 1.将 suffixExpression分割
        String[] split = suffixExpression.split(" ");
        return Arrays.asList(split);
    }
}
