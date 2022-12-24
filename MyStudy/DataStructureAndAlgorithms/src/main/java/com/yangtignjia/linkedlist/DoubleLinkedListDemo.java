package com.yangtignjia.linkedlist;

/**
 * 杨廷甲
 * 2022-10-05
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        HeroNode2 hero5 = new HeroNode2(5, "张的撒", "大大大");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        System.out.println("加入最后");
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.add(hero5);

        System.out.println("原来的链表");
        doubleLinkedList.list();

        //修改
        HeroNode2 heroNode = new HeroNode2(4, "冲冲", "宝宝");
        doubleLinkedList.update(heroNode);
        System.out.println("更新后");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.delete(4);
        System.out.println("删除后");
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    //初始化一个头节点，不要动
    HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //遍历
    //显示链表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动所以我们需要有一个临时变量来遍历
        HeroNode2 temp = head.next;
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

    //添加（默认添加到双向链表的最后）
    //思路分析：当不考虑编号顺序时
    //1.找到链表的最后的节点
    //temp.next = heroNode;
    //heroNode.per = temp;
    public void add(HeroNode2 heroNode) {
        //因为head节点不能动，所以要想遍历链表找到链表的最后的节点就需要一个临时变量来保存这个遍历到的节点信心
        HeroNode2 temp = head;
        while (true) {
            //遍历链表当链表的最后一节点的next为null则是最后一个节点
            if (temp.next == null) {
                break;
            }
            //如果当前节点不是最后一个节点那么将节点后移
            temp = temp.next;
        }
        //当退出链表循环时，temp就指向了链表的最后
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.per = temp;
    }

    //更新双向链表的节点x信息
    public void update(HeroNode2 newHeroNode) {
        //判断一下链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //需要一个辅助变量来寻找要更新的链表节点
        HeroNode2 temp = head.next;
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
    //对于双向链表可以直接删除
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
        }

        HeroNode2 temp = head.next; //辅助指针
        boolean flag = false;
        while (true) {
            if (temp.next == null) {//已经到达链表的最后
                break;
            }
            if (temp.no == no) {
                //找到待删除节点的前一个节点，说明找到了
                flag = true;
                break;
            }
            //后移遍历
            temp = temp.next;
        }
        if (flag) {
            //找到了可以删除
            temp.per.next = temp.next;
            //这里有风险，如果是最后一个节点，所以要判断是否是最后一个节点
            if (temp.next != null) {
                temp.next.per = temp.per;
            }
        }else {
            System.out.printf("要删除的节点%d 不存在",no);
        }

    }
}

//定义一个HeroNode节点,每一个HeroNode对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next; //指向下一个节点
    public HeroNode2 per; //指向前一个节点

    //构造器
    public HeroNode2(int no, String name, String nickName) {
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


