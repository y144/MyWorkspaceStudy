package com.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 杨廷甲
 * 2022-08-14
 */
public class Send {

    public static void main(String[] args) {

        //创建工厂对象 用于指定连接的信息
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.78.130");
        factory.setPort(5672); // 指定连接端口 这个端口时Broker的端口
        factory.setUsername("root");
        factory.setPassword("root");

        //准备连接,以及连接并添加异常处理的同时在try catch执行完成后自动释放资源
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()){
            /**
             * 声明一个队列
             * 参数1：队列名称，为任意值，如果这个名称存在则放弃创建，否则在MQ服务器中创建这个队列
             * 参数2：为是否持久化的队列
             * 参数3：为是否排外的队列，true表示排外，同时只允许有一个消费者监听这个队列
             * 参数4：是否自动删除，true表示自动删除，当没有消费者监听这个队列的时候将自动删除队列以及消息
             * 参数5：为队列的属性设置，通常设置为null
             * 注意：
             *  这行代码是可选代码，但是要在发送 消息前确保队列存在否则将丢失消息
             */
            String queueName = "myQueue";
            channel.queueDeclare(queueName,true,false,false,null);

            String message = "测试消息";

            /**
             * 发送消息到MQ
             * 参数1：为交换机名称，我们这个里没有使用交换机因此为“”
             * 参数2：为消息所携带的RoutingKey,由于没有使用交换机因此这个参数被识别成了队列的名称
             * 参数4: 为消息的属性设置通常设置为null
             * 参数5：为具体的消息的数据取值为byte数组(建议String传递消息)
             * 注意：
             *  消息发送之前要确保队列已经存在否则会丢失消息
             */

            channel.basicPublish("",queueName,null, message.getBytes());
            System.out.println("消息发送成功");
        }catch (TimeoutException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
