package com.lark.socket.api.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author:zhuqz
 * description:应答前端消息体
 * date:2019/10/16 14:32
 **/
@Data
public class SocketMsgDetailVo implements Serializable {
    private static final long serialVersionUID = -820977987664126610L;
    /**编码 与 MessageType编码一一对应 因为前段是数字，这里暂时不能使用string*/
    private int code ;
    /**消息内容*/
    private Object data;
}
