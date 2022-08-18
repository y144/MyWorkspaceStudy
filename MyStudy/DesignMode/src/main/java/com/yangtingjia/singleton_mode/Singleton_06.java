package com.yangtingjia.singleton_mode;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 杨廷甲
 * 2022-06-23
 */
public class Singleton_06 {
    /**
     * CAS "AtomicReference"  线程安全的
     *
     * java 并发库中提供了很多原子类支持并发访问的数据安全性，
     * 可以封装引用一个对象的实例，下面支持并发访问的单例模式就是利用了这种特性
     * 使用CAS 的好处是不需要使用传统的加锁方式，而是依赖CAS的忙等算法，底层硬件的实现线程的安全
     * 现对于其他锁的实现，没有线程的切换和阻塞就没有了额外的开销
     * 并且可以支持较大的并发
     * 当然CAS也有一个缺点就是等忙，如果一直没有获取到时间，就会陷于死循环
     */

    private static final AtomicReference<Singleton_06> INSTANCE = new AtomicReference<Singleton_06>();

    private static Singleton_06 instance;

    private Singleton_06(){

    }
    public static final Singleton_06 getInstance(){
        for (;;){
            Singleton_06 instance = INSTANCE.get();
            if (null != instance) return instance;
            INSTANCE.compareAndSet(null, new Singleton_06());
            return INSTANCE.get();
        }
    }

    public static void main(String[] args) {
        System.out.println(Singleton_06.getInstance());

        System.out.println(Singleton_06.getInstance());
    }

}
