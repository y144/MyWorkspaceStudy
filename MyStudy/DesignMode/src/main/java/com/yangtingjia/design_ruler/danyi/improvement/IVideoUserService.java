package com.yangtingjia.design_ruler.danyi.improvement;

/**
 * 杨廷甲
 * 2022-07-02
 */
public interface IVideoUserService {

    //视屏清晰级别 480 720 1080
    void definition();

    //广告的播放方式：有广告 无广告
    void advertisement();

    /**
     * 定义出一个上层的接口，统一定义需要实现的功能，包括视屏的清晰度接口 广告播放方式的接口
     * 三种用户就可以分别实现自己的服务类，做到职责的统一
     */
}
