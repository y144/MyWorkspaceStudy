package com.yangtingjia.singleton_mode;

/**
 * 杨廷甲
 * 2022-06-23
 */
public class Singleton_05 {
    /**
     * 双重锁校验  线程安全
     *
     * 双重锁的方式是方法及锁的优化，
     * 减少了获取实例的耗时
     * 同时 这种方式也满足了懒汉模式
     */

    private static volatile Singleton_05 instance;

    private Singleton_05(){

    }

    public static Singleton_05 getInstance(){
        if (instance == null) return instance;

        synchronized (Singleton_05.class){
            if (null == instance) {
                instance = new Singleton_05();
            }
        }
        return instance;
    }
}
