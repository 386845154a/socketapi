package com.lark.socket.api.config;

import com.alibaba.fastjson.JSONObject;
import com.lark.socket.api.vo.SocketMsgVo;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @auther: zhuqz
 * @date: 2020/3/9 13:18
 * @description: 消息生产
 */
public class Producer {
    //1成功 0失败
     public static int sendMsgToSockerSever(String exchangeName, String routingkey, SocketMsgVo msg)throws Exception{
         try {
             //实例连接工厂
             ConnectionFactory connectionFactory=RabbitConfig.getConnectionFactory();
             Connection connection = connectionFactory.newConnection();
             //创建通道
             Channel channel = connection.createChannel();
             AMQP.BasicProperties props = new AMQP.BasicProperties.Builder().deliveryMode(2).contentEncoding("UTF-8").build();
             String msgJson = JSONObject.toJSONString(msg);
             // 基本发布消息
             // 第一个参数为交换机名称、
             // 第二个参数为队列映射的路由key、
             // 第三个参数为消息的其他属性、
             // 第四个参数为发送信息的主体
             channel.basicPublish(exchangeName,routingkey,props,msgJson.getBytes("utf-8"));
             channel.close();
             connection.close();
         } catch (IOException e) {
             e.printStackTrace();
             return 0;
         } catch (TimeoutException e) {
             e.printStackTrace();
             return 0;
         }
         return  1;
     }
}