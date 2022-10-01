package com.yangtignjia.queue;

import java.util.Scanner;

/**
 * 杨廷甲
 * 2022-10-01
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        //1.初始化队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;


        //输出一个菜单
        while (loop) {
            System.out.println("s(show) 显示队列");
            System.out.println("e(exit) 退出程序");
            System.out.println("a(add) 添加数据");
            System.out.println("g(get) 从队列里面获取数据");
            System.out.println("h(head) 查看队列头数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's' :
                    queue.showQueue();
                    break;
                case 'a' :
                    System.out.println("请输入一个数字");
                    int a = scanner.nextInt();
                    queue.addQueue(a);
                    break;
                case 'g' :
                    try {
                        int i = queue.getQueue();
                        System.out.printf("获取到的数据为:%d\n",i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h' :
                    try {
                        int head = queue.headqqQueue();
                        System.out.printf("队列头的数据为：%d\n" ,head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e' :
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

//编写一个类 使用数组模拟队列
class ArrayQueue {
    private int maxSize; // 队列的最大容量
    private int front; // 队列头指针
    private int rare; //队列尾指针
    private int[] arr; //模拟队列的数组 存放数据

    //创建队列 构造方法
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        front = -1;
        rare = -1;
        arr = new int[maxSize];
    }

    //判断队列是否为满
    public boolean isFull() {
        return rare == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rare == front;
    }

    //添加数据
    public void addQueue(int n) {
        //判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满，不能加入数据");
            return;
        }
        rare++; //让rare+1 他的尾指针向后移一位
        arr[rare] = n;
    }

    //出队列 删除数据
    public int getQueue() {
        if (isEmpty()) {
            //通过跑异常来处理
            throw new RuntimeException("队列为空，不能取数据");
        }
        front++; //后移，因为他本来就是在头的前一位
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    //显示队列的头数据，不是取出数据
    public int headqqQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front+1];
    }
}
