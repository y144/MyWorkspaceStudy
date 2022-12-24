package com.yangtignjia.linkedlist;

import java.util.Stack;

/**
 * 杨廷甲
 * 2022-10-03
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(5, "张的撒", "大大大");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        System.out.println("加入最后");
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero5);

        System.out.println("原来的链表");
        singleLinkedList.list();

        System.out.println("逆序打印");
        reversePrint(singleLinkedList.getHead());

        /*System.out.println("加入按照编号");
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.list();

        HeroNode newHero = new HeroNode(2, "卢看看", "玉小星星");
        singleLinkedList.update(newHero);

        System.out.println("修改之后的链表信息");
        singleLinkedList.list();

        singleLinkedList.delete(1);
        System.out.println("删除后的链表信息");
        singleLinkedList.list();

        System.out.println("有效的节点个数 = " + getLength(singleLinkedList.getHead()));

        //测试获取倒数第K元素
        HeroNode lastIndexHeroNode = findLastIndexHeroNode(singleLinkedList.getHead(), 1);
        System.out.println(lastIndexHeroNode);*/
    }

    /**
     * 逆序打印单链表
     * @param head
     */
    public static void reversePrint(HeroNode head) {
        //链表为空不能打印
        if (head.next == null) {
            return;
        }
        //遍历链表将链表元素压入栈中
        HeroNode cur = head.next; //遍历的当前节点
        Stack<HeroNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //遍历栈中元素打印
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 反转单链表
     * @param head 反转链表的头结点
     * 思路分析：
     *  1.先定义一个节点，reverseHead = new HeroNode()
     *  2.遍历原来的链表，每遍历一个就将其取出，放在reverseHead的最前面
     *  3.原来的链表head.next = reverseHead.next
     */
    public static void reverseList(HeroNode head) {
        //如果链表为空或者链表只有一个节点就不需要反转直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //需要定义一个辅助变量来遍历链表
        HeroNode cur = head.next;
        //需要定义一个next ，指向当前节点cur的下一个节点
        HeroNode next = null;
        //定义一个reverseHead节点
        HeroNode reverseHead = new HeroNode(0, "", "");

        //循环遍历链表
        while (cur != null) {
            next = cur.next; //先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next= reverseHead.next; //让当前节点的下一个节点指向新链表的最前端
            reverseHead.next = cur; // 将cur连接到新的链表上
            cur = next; //后移cur
        }
        head.next = reverseHead.next;

    }

    /**
     * 获取单链表的有效个数（如果是带头结点的链表需求不统计头结点（百度面试）
     * @param head 链表的头结点
     * @return 链表的有效个数
     */
    public static int getLength(HeroNode head) {
        if (head.next ==null) {
            return 0;
        }
        int length = 0;
        //定义一个辅助变量
        HeroNode cur = head.next; //没有统计头节点
        while (cur != null) {
            length++;
            cur = cur.next; //遍历
        }
        return length;
    }

    //查找单链表中倒数第K个节点 （新浪面试）
    /**
     * 思路：
     * 1编写一个方法，接收 head节点和index
     * 2.index 表示倒数第index节点
     * 3.先把链表从头到尾遍历得到总的长度 getLength()
     * 4. 遍历链表的（size - index） 就可以
     * 5.找到就返回该节点否则返回null
     */
    public static HeroNode findLastIndexHeroNode(HeroNode head,int index) {
        //判断链表是否为空
        if (head.next == null) {
            return null;
        }
        //第一次遍历得到链表的总长度
        int length = getLength(head);
        //第二次遍历 size - length  位置，就是我们倒数第k个节点
        //数据校验
        if (index <= 0 || index > length) {
            return null;
        }
        //定义一个辅助变量
        HeroNode cur = head.next;
        for (int i = 0; i < length - index; i++) {
             cur = cur.next;
        }
        return cur;
    }

}

//定义一个SingleLinkedList 管理英雄
class SingleLinkedList {
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public SingleLinkedList setHead(HeroNode head) {
        this.head = head;
        return this;
    }

    //添加节点到单向链表
    //思路分析：当不考虑编号顺序时
    //1.找到链表的最后的节点
    //2.将这个节点的next指向新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动，所以要想遍历链表找到链表的最后的节点就需要一个临时变量来保存这个遍历到的节点信心
        HeroNode temp = head;
        while (true) {
            //遍历链表当链表的最后一节点的next为null则是最后一个节点
            if (temp.next == null) {
                break;
            }
            //如果当前节点不是最后一个节点那么将节点后移
            temp = temp.next;
        }
        //当退出链表循环时，temp就指向了链表的最后
        //找到了链表的最后，将最后这个节点的next指向新添加的节点就完成了添加
        temp.next = heroNode;
    }

    //第二种添加英雄的方式
    public void addByOrder(HeroNode heroNode) {
        //因为头结点不能动，我们任然需要一个辅助变量来找到要添加的位置
        //因为单链表因此我们要找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false; //标识添加的编号是否存在 存在则不能添加
        while (true) {
            if (temp.next == null) {
                //在链表最后
                break;
            }
            if (temp.next.no > heroNode.no) {
                //找到了
                break;
            }
            if (temp.next.no == heroNode.no) {
                //编号已经存在
                flag = true;
                break;
            }
            temp = temp.next; //后移
        }
        //判断flag
        if (flag) {
            //不能添加。编号已经存在
            System.out.printf("准备插入的英雄编号%d已经存在，不能加入\n", heroNode.no);
        } else {
            //可以添加
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //更新链表的节点x信息
    public void update(HeroNode newHeroNode) {
        //判断一下链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //需要一个辅助变量来寻找要更新的链表节点
        HeroNode temp = head.next;
        //标识是否找到节点
        boolean flag = false;
        //遍历链表
        while (true) {
            if (temp == null) {
                System.out.println("已经遍历完列表");
                break;
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            //后移
            temp = temp.next;
        }
        //遍历完成后，需要知道是否已经找到
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            System.out.printf("没没有找到编号%d的节点，不能修改",newHeroNode.no);
        }

    }

    //根据链表节点编号删除链表信息
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {//已经到达链表的最后
                break;
            }
            if (temp.next.no == no) {
                //找到待删除节点的前一个节点，说明找到了
                flag = true;
                break;
            }
            //后移遍历
            temp = temp.next;
        }
        if (flag) {
            //找到了可以删除
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的节点%d 不存在",no);
        }

    }


    //显示链表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动所以我们需要有一个临时变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断链表是否到最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //temp后移
            temp = temp.next;
        }
    }


}


//定义一个HeroNode节点,每一个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next; //指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    //为了显示方便重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
