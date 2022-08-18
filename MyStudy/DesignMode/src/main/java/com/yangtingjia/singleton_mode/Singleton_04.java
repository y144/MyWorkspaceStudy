package com.yangtingjia.singleton_mode;

/**
 * 杨廷甲
 * 2022-06-23
 */
public class Singleton_04 {
    /**
     * 使用类的内部类实现单例模式 线程安全的
     * 使用类的静态内部类实现的单例模式
     * 既保证了线程的安全，又保证了懒汉模式，同时不会因为加锁而降低性能
     *
     * 这主要是因为JVM虚拟机可以保证多线程并发访问的正确性
     * 也就是一个类的构造方法在多线程的环境下可以被正确的加载
     * 所以这也是推荐使用的一种单例模式
     */
    private static class SingletonHolder {
        private static Singleton_04 instance = new Singleton_04();
    }

    private Singleton_04(){

    }

    public static Singleton_04 getInstance(){
        return SingletonHolder.instance;
    }
}