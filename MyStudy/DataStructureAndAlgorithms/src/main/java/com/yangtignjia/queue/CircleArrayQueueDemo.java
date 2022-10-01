package com.yangtignjia.queue;

/**
 * 杨廷甲
 * 2022-10-02
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {

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
}
