package com.yangtingjia.singleton_mode;

/**
 * 杨廷甲
 * 2022-06-23
 */
public class Singleton_01 {

    /**
     * 懒汉模式 线程不安全
     *
     * 单例模式有一个特点是不允许外部直接创建，也就是new Singleton()
     * 因此这里再模式的构造函数的上添加了私有的属性private
     * 虽然采用此种方法的单例满足了懒汉模式，但是如果有多个访问者同时获取对象实例，
     * 就会造成同时多个同样的实例并存，并没有达到单例的要求
     *
     */
    private static Singleton_01 instance;

    private Singleton_01(){

    }

    private static Singleton_01 getInstance() {
        if (null != instance) return instance;
        instance = new Singleton_01();
        return instance;
    }
}
