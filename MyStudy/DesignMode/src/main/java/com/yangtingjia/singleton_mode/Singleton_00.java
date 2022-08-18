package com.yangtingjia.singleton_mode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 杨廷甲
 * 2022-06-23
 */

//通过静态类实现单例模式
public class Singleton_00 {

    // 单例模式主要解决的是一个全局使用的类，被频繁的创建和销毁，从而的提升代码的整体性能

    public static Map<String,String> cache = new ConcurrentHashMap<>();

    /**
     * 这种静态方式在开发中也比较常见，
     * 他可以在第一次运行时直接初始化Map类同时也不需要直接直到延迟加载再使用
     * 在不需要维持任何状态的情况下，仅仅用于全局访问，使用静态类更加方便
     * 在需要被继承以及维持一些特定状态的情况下，适合使用单例模式
     *
     */
}
