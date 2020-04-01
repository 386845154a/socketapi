package com.lark.socket.api.config;

import lombok.Data;

/**
 * @auther: zhuqz
 * @date: 2020/3/9 11:13
 * @description:
 */
@Data
public class RabbitProperties {
    private String host;
    private String prot;
    private String name;
    private String password;
    private String vhost;
}