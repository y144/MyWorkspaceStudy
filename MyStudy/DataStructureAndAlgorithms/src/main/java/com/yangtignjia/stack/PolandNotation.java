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
        //3.中缀表达式对应的list转为对应的后缀表达式list

        String expression = "1+((2+3)*4)-5";
        System.out.println("中缀表达式 = " + expression);
        List<String> list = toInfixExpression(expression);
        System.out.println("中缀表达式对应的list = " + list);

        List<String> parseSuffixExpressionList = parseSuffixExpressionList(list);
        System.out.println("后缀表达式对应的list = " + parseSuffixExpressionList);

        System.out.printf("expression = %d\n" , calculate(parseSuffixExpressionList));


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
        //定义两个栈
        Stack<String> s1 = new Stack<String>(); // 符号栈
        //应为s2这个栈，在整个转换过程中没有pop操作，而且最后我们还要逆序输出结果
        //因此比较麻烦，因此我们在这里不使用栈了就直接使用一个list
        //Stack<String> s2 = new Stack<String>(); //中间结果栈
        List<String> s2 = new ArrayList<String>();

        //遍历list
        for (String item : list) {
            //如果是一个数，就加入数栈 s2
            if (item.matches("\\d+")) {
                s2.add(item);
            }else if (item.equals("(")) {
                s1.push(item);
            }else if (item.equals(")")) {
                //如果是右括号 ） 就一次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop(); //将 左括号 （ 弹出s1栈，消除小括号
            }else {
                //当item运算符的优先级小于或等于s1栈顶运算符，将s1栈顶的运算符弹出并加入到s2中，
                // 再次转到4.1中与s1中新的栈顶运算符相比较
                // 问题：缺少一个比较优先级高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //还需要将item压入符号栈
                s1.push(item);
            }
        }

        //将s1中剩余的运算符依次压入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        //注意 因为是将结果存放到list中，因此按照list的顺序输出就是对应的后缀表达式对应的list
        return s2;
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

//这个类返回一个运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //方法 返回对应优先级的数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            case "(":
                break;
            case ")":
                break;
            default:
                throw new RuntimeException("不存在该运算符");
        }
        return result;
    }

}