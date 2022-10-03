package com.yangtignjia.queue;

import java.util.Scanner;

/**
 * 杨廷甲
 * 2022-10-02
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        System.out.println("测试数组模拟环形队列");
        //1.初始化队列
        CircleArray queue = new CircleArray(4); //设置说明，其队列的有效数据最大是3 因为我们在设计的时候，会预留一个位置作为约定
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

class CircleArray {
    private int maxSize; // 队列的最大容量
    //front 变量的含义做一个调整 front指向队列的第一个元素 也就是说arr[front] 就是队列的第一个元素
    // front 初始值 = 0
    private int front;
    //rare 变量的含义做一个调整 rare指向队列的最后一个元素的后一个位置 因为希望空出一个空间 作为约定
    // rare 初始值 = 0
    private int rare;
    private int[] arr; //模拟队列的数组 存放数据

    //创建队列 构造方法
    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否为满
    public boolean isFull() {
        return (rare + 1)%maxSize == front;
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
        //直接将数据加入队列
        arr[rare] = n;
        //将rare取模，这里必须考虑取模
        rare = (rare + 1)%maxSize;
    }

    //出队列 删除数据
    public int getQueue() {
        if (isEmpty()) {
            //通过跑异常来处理
            throw new RuntimeException("队列为空，不能取数据");
        }
        //这里要考虑front是指向队列的第一个元素
        //1.先把front对应的值保留到一个临时变量
        //2.将front后移 考虑取模
        //3.将临时变量返回
        int value = arr[front];
        front = (front +1)%maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
        }
        //这里要从front开始遍历 遍历有效个数据
        for (int i = front; i < front +size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //获取队列中有效数据的个数
    public int size() {
        return (rare + maxSize - front) % maxSize;
    }

    //显示队列的头数据，不是取出数据
    public int headqqQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }


}
