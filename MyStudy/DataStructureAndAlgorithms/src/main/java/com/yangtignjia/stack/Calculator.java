package com.yangtignjia.stack;

/**
 * 杨廷甲
 * 2022-12-24
 */
public class Calculator {
    public static void main(String[] args) {

        //计算表达式
        String express = "30+2*6-2";
        //创建两个栈一个数栈一个符号栈
        ArrayStack2  numStack = new ArrayStack2(10);
        ArrayStack2  operStack = new ArrayStack2(10);
        //定义需要的相关变量
        int index = 0; //定义一个指针用于扫描 表达式
        int num1 = 0;
        int num2 = 0;
        int opera = 0;
        int res = 0;
        char ch = ' '; //将每次扫描得到的char保存到ch
        String keepNum = ""; //用于处理多位数
        //循环扫描表达式
        while (true) {
            ch = express.substring(index ,index+1).charAt(0);
            if (operStack.isOper(ch)) {
                //如果是符号
                if (!operStack.isEmpty()) {
                    /**
                     * 如果符号栈有操作符就进行比较
                     * 如果当前的操作符的优先级小于或者等于栈中的操作符，就需要从数栈中pop出两个数
                     * 再从符号栈中pop出一个符号，进行运算，将得到的结果入数栈，然后将当前的操作符入符号站
                     */
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        opera = operStack.pop();
                        res = numStack.cal(num1, num2, opera);
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        //如果当前的操作符的优先级大于符号栈中的优先级则直接入符号栈
                        operStack.push(ch);
                    }
                }else {
                    //如果为空直接入栈
                    operStack.push(ch);
                }
            }else {
                 //如果是数直接入数栈
                //numStack.push(ch - 48);
                keepNum += ch;
                if (index == express.length() -1) {
                    numStack.push(Integer.parseInt(keepNum));
                }else {

                    if (operStack.isOper(express.substring(index +1 ,index +2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            //扫描指针+1 并判断是否扫描到表达式的最后
            index++;
            if (index >= express.length()) {
                break;
            }

        }

        /**
         * 当表达式扫描完毕，就顺序的从数栈和符号栈中 pop出相应的数 和 符号进行运算
         */
        while (true) {
            //如果符号栈为空则计算到最后，数栈中只有一一个数字就是结果
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            opera = operStack.pop();
            res = numStack.cal(num1, num2, opera);
            numStack.push(res);
        }
        System.out.printf("表达式%s的结果是:%d",express,numStack.pop());

    }
}

//定义一个数组栈
class ArrayStack2 {

    //栈的大小
    private int maxSize;
    //数组模拟栈
    private int[] stack;
    //栈顶 初始化为-1
    private int top = -1;

    //构造器
    public ArrayStack2 (int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }
    //栈空
    public boolean isEmpty() {
        return top == -1;
    }
    //入栈
    public void push (int value) {
        //先判断栈是否满了
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈
    public int pop() {
        //判断栈是否为空
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //遍历栈
    public void list() {
        //判断栈空
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i > 0 ; i--) {
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }

    //返回运算符的优先级，优先级是程序员定的，优先级使用数字表示
    //数字越大优先级越高
    public int priority(int opr) {
        if (opr == '*' || opr == '/') {
            return 1;
        }else if (opr == '+' || opr == '-') {
            return 0;
        }else {
            return -1; //假定目前的运算符中只有+ - * /
        }
    }
    //判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
    //查看栈顶元素
    public int peek() {
        return stack[top];
    }
}
