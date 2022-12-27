package com.yangtignjia.stack;

import java.util.Scanner;

/**
 * 杨廷甲
 * 2022-12-24
 */
public class ArrayStackDemo {
    public static void main(String[] args) {

        //测试数组模拟栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true; //控制程序是否退出
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 表示退出程序");
            System.out.println("push: 表示入栈");
            System.out.println("pop: 表示出栈");
            System.out.println("请输入你得选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int pop = stack.pop();
                        System.out.printf("出栈的数是 :%d\n", pop);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

//定义一个数组栈
class ArrayStack {

    //栈的大小
    private int maxSize;
    //数组模拟栈
    private int[] stack;
    //栈顶 初始化为-1
    private int top = -1;

    //构造器
    public ArrayStack (int maxSize) {
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
}
