package com.lark.socket.api.config;

import com.lark.socket.api.vo.MsgSendResultVo;
import com.lark.socket.api.vo.SocketMsgVo;
import com.rabbitmq.client.ConnectionFactory;

import java.io.*;
import java.util.Map;
import java.util.Properties;

/**
 * @auther: zhuqz
 * @date: 2020/3/6 16:32
 * @description:
 */
public class RabbitConfig {


    private volatile static ConnectionFactory connectionFactory ;
    public   static ConnectionFactory getConnectionFactory(){
        if(connectionFactory==null){
            synchronized (RabbitConfig.class){
                connectionFactory = new ConnectionFactory();
                RabbitProperties rabbitProperties = getRabbitMqProperties();
                connectionFactory.setHost(rabbitProperties.getHost());
                connectionFactory.setPort(Integer.valueOf(rabbitProperties.getProt()));
                connectionFactory.setPassword(rabbitProperties.getPassword());
                connectionFactory.setUsername(rabbitProperties.getName());
                // 网络异常自动连接恢复
                connectionFactory.setAutomaticRecoveryEnabled(true);
                // 每10秒尝试重试连接一次
                connectionFactory.setNetworkRecoveryInterval(10000);
            }
        }
         return connectionFactory;
    }
    private static RabbitProperties getRabbitMqProperties(){
        Properties props = new Properties();
        RabbitProperties properties = new RabbitProperties();
        try {
            InputStream ips = RabbitConfig.class.getResourceAsStream("rabbitmq.properties");
            BufferedReader ipss = new BufferedReader(new InputStreamReader(ips));
            props.load(ipss);
            String host = props.get("rabbitmq-host").toString();
            String port = props.get("rabbitmq-port").toString();
            String user = props.get("rabbitmq-user").toString();
            String pwd = props.get("rabbitmq-pwd").toString();
            properties.setHost(host);
            properties.setProt(port);
            properties.setName(user);
            properties.setPassword(pwd);
        } catch (FileNotFoundException e) {
            System.out.println("无法找到文件:rabbitmq.properties");
            return null;
        } catch (IOException e) {
            System.out.println("读文件出错:rabbitmq.properties"+"---"+e.getMessage());
            return null;
        }
        return properties;
    }


}