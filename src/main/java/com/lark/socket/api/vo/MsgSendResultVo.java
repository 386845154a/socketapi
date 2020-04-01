package com.lark.socket.api.vo;

import lombok.Data;

/**
 * @author:zhuqz
 * description: 消息发送到mq是否成功
 * date:2020/2/7 19:39
 **/
@Data
public class MsgSendResultVo {
    /**是否发送成功true，false*/
    private Boolean status = true;
    /**提示说明*/
    private String content = "成功";
}
