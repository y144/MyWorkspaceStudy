package com.yangtingjia.singleton_mode;

/**
 * 杨廷甲
 * 2022-06-23
 */
public enum  Singleton_07 {
    /**
     * 枚举单例  线程安全
     * 可解决线程安全、自由串行化、单一实例问题
     * 即使在面对复杂的串行化的或者反射攻击时也提供了无偿的串行化机制拒绝防止对此实例化
     */
    INSTANCE;
    public void test(){
        System.out.println("hi");
    }

}
