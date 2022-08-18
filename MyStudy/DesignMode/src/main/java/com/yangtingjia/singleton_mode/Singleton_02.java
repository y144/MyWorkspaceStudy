package com.yangtingjia.singleton_mode;

/**
 * 杨廷甲
 * 2022-06-23
 */
public class Singleton_02 {
    /**
     * 懒汉模式 线程安全
     *
     * 这种模式虽然是线程安全的，但由于把锁加到方法中后，所有的访问因为需要所的占用
     * 导致资源浪费
     * 除非在特殊的情况下，否则不建议用此种方法实现单例模式
     */

    private static Singleton_02 instance;

    private Singleton_02(){

    }

    private static synchronized Singleton_02 getInstance() {
        if (null != instance) return instance;
        instance = new Singleton_02();
        return instance;
    }
}
