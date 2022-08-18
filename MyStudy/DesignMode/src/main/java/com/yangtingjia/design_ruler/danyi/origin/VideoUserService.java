package com.yangtingjia.design_ruler.danyi.origin;

/**
 * 杨廷甲
 * 2022-07-02
 */
public class VideoUserService {
    public void serveGrade(String userType) {
        if ("VIP会员".equals(userType)) {
            System.out.println("VIP会员，视屏1080p蓝光");
        }else if ("普通会员".equals(userType)) {
            System.out.println("普通会员，720p超清");
        }else if ("访客用户".equals(userType)) {
            System.out.println("访客当用户，视屏480p高清");
        }
    }

    /**
     * 如上实现的代码逻辑非常的简单 ，暂时也不会出现什么问题，但是这一个类里面包含着多个不同的行为，也就是用户的等多种职责。如果在这样的类上继续扩展功能或添加逻辑就会显得非常的臃肿
     */
    public static void main(String[] args) {
        VideoUserService service = new VideoUserService();
        service.serveGrade("VIP会员");
        service.serveGrade("普通会员");
        service.serveGrade("访客用户");
    }

    /**
     *上面的实现方式是在一个if else中实现的，所以在调用方法的时候是所有的职责用户都使用一个方法实现，作为程序的调用入口
     * 对于简单的或者几乎不需要迭代的功能这种实现也未尝不可。
     * 但是如果面对的是频繁跌单的业务需求，这样的代码就很难支撑系统的迭代。每一次的需求的实现都可能会影响其他的逻辑，给整个接口服务带来不可控制的风险
     */
}
