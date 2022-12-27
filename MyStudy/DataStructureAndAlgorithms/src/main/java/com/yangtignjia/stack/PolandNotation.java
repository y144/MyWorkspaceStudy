package com.yangtignjia.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 杨廷甲
 * 2022-12-27
 */
public class PolandNotation {
    public static void main(String[] args) {

        //完成一个中缀表达式转为后缀表达式的转换
        //说明
        //1. 1 + ((2 + 3) * 4) - 5 => 1 2 3 + 4 * + 5 -
        //2.因为不方便直接对字符串进行扫描  则将中缀表达式的字符串放入list中
        //3.中缀表达式转后缀表达式
        String expression = "1+((2+3)*4)-5";
        List<String> list = toInfixExpression(expression);
        System.out.println(list);



        //先定义一个逆波兰表达式 (3+4) * 5 -6 --> 3 4 + 5 * 6 -
        //说明 为了方便 逆波兰表达式中的数字与符号用空格隔开
        String suffixExpression = "30 4 + 5 * 6 -";
        //1.先将suffixExpression 放入到arrayList中
        //2.将arrayList传递给一个方法，这个方法中遍历arrayList配合栈完成计算
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList = " + rpnList);

        int res = calculate(rpnList);
        System.out.println("计算的结果是 = " + res);

    }

    // 将中缀表达式的list 转为 对应的后缀表达式的list
    public static List<String> parseSuffixExpressionList(List<String> list) {
        return list;
    }

    //将中缀表达式转换为对应的list
    public static List<String> toInfixExpression(String express) {
        List<String> list = new ArrayList<>();
        int i = 0; //这是一个指针用于遍历中缀表达式的字符串
        String str; //对多位数的拼接
        char c; //遍历到每个字符将放入c
        do {
            //如果c是一个非数字就需要加入到list
            if ((c = express.charAt(i)) < 48 || (c = express.charAt(i)) > 57) {
                list.add(""+c);
                i++;
            }else {
                //如果是一个数字就需要拼接
                str = ""; //先将str置为空 0[48] - 9[57] 对应的阿斯克码
                while (i < express.length() &&
                        (c = express.charAt(i)) >= 48 &&
                        (c = express.charAt(i)) <= 57) {
                    str += c; //拼接
                    i++;
                }
                list.add(str);
            }
        }while (i < express.length());
        return list;
    }

    //将这个逆波兰表达式依次将数据和运算符放入arrayList中
    public static List<String> getListString(String suffixExpression) {
        // 1.将 suffixExpression分割
        String[] split = suffixExpression.split(" ");
        return Arrays.asList(split);
    }

    //完成对逆波兰表达式的运算
    /**
     * 思路分析
     * 1.从左至右扫描，将3和4压入堆栈
     * 2.遇到 + 运算符因此弹出4 和 3（4为栈顶元素，3为次顶元素） 计算3+4的值 得7 再将7入栈
     * 3.将5入栈
     * 4.接下来是 * 运算符 因此弹出5和7 计算 7*5=35 将35入栈
     * 5.将6入栈
     * 6.最后是-运算符 计算出35 - 6 的值 即为答案
     */
    public static int calculate(List<String> list) {
        //创建栈
        Stack<String> stack = new Stack<>();
        //变量list
        for (String item : list) {
            //这里使用正则表达式来取数
            if (item.matches("\\d+")) { //匹配多位数
                //直接入栈
                stack.push(item);
            }else {
                //pop出两个数 并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                }else if (item.equals("-")) {
                    res = num1 - num2;
                }else if (item.equals("*")) {
                    res = num1 * num2;
                }else if (item.equals("/")) {
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算符有错误");
                }
                stack.push(res + "");
            }
        }
        //最后留在stack中的数就是结果
        return Integer.parseInt(stack.pop());
    }
}
