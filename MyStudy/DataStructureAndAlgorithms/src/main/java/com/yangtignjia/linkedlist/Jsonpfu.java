package com.yangtignjia.linkedlist;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 杨廷甲
 * 2022-10-05
 */
public class Jsonpfu {
    public static void main(String[] args) {
        //测试构件环形链表，遍历
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        //circleSingleLinkedList.showBoy();

        //出圈ces
        circleSingleLinkedList.countBoy(1, 2, 5);
    }
}

//创建环形单项链表
class CircleSingleLinkedList {
    //创建一个first节点，当前没有编号
    private Boy first = new Boy(-1);

    //添加节点，构件环形链表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null; //辅助指针帮助构件环形链表
        //创建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号创建节点
            Boy boy = new Boy(i);
            //如果是第一个节点
            if (i == 1) {
                first = boy;
                first.setNext(first); //构成环
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历环形链表
    public void showBoy() {
        //判断是否为kong
        if (first == null) {
            System.out.println("链表为空");
            return;
        }

        //辅助指针因为first不能动
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                //遍历完毕
                break;
            }
            curBoy = curBoy.getNext(); //后移
        }
    }

    /**
     * 根据用户输入计算小孩出圈的顺序
     *
     * @param startNo 表示从第几个小孩开始数数
     * @param countNo 表示数几下
     * @param nums    表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNo, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
        }
        //创建辅助指针，帮助小孩出圈
        Boy helper = first;
        //将这个辅助指针指向环形链表的最后
        while (true) {
            if (helper.getNext() == first) {
                //到最后了
                break;
            }
            helper = helper.getNext();
        }
        //报数前先让first 和helper移动k - 1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时让first和helper同时移动m - 1 次，然后出圈
        while (true) {
            if (helper == first) {
                //说明圈中只有一个节点了
                break;
            }
            //让first和helper同时移动countNum - 1
            for (int j = 0; j < countNo - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这是first指向的节点就是要出圈的节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //这是将first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号是%d \n", first.getNo());
    }

}

//先创建一个Boy类，表示一个节点
class Boy {
    private int no; //编号
    private Boy next; //指向下一个节点 默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Boy setNo(int no) {
        this.no = no;
        return this;
    }

    public Boy getNext() {
        return next;
    }

    public Boy setNext(Boy next) {
        this.next = next;
        return this;
    }
}
