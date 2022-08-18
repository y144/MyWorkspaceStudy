package com.yangtingjia.singleton_mode;

/**
 * 杨廷甲
 * 2022-06-23
 */
public class Singleton_03 {
    /**
     * 饿汉模式 线程安全
     *
     * 这种方式与开头的第一个实例化Map基本一致，在程序启动的时候直接运行加载，后续有外部需要使用时直接获
     * 这种方式并不是懒加载
     * 也就是说无论程序中是否用到这样的类，都会在程序启动之初进行创建
     * 这种方式造成的问题，就像一款游戏软件可能游戏地图还没有打开，但是程序已经将这些地图全部实例化
     * 在手机上最明显的体验就是打开游戏，提示内训满了，造成手机卡顿
     */
    private static Singleton_03 instance = new Singleton_03();

    private Singleton_03(){

    }

    private static Singleton_03 getInstance(){
        return instance;
    }
}
