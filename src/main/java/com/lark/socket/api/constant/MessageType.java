package com.lark.socket.api.constant;

/**
 *@Description: 消息码
 *@Param:
 *@return:
 *@Author: 忠
 *@date: 2019/5/29
 */
public class MessageType {

    /**群体消息**/
    public static final String SOCKET_TEAM = "100000";
    /**单人消息**/
    public static final String SOCKET_SINGLE = "200000";
    /**群体socket群体绑定**/
    public static final String SOCKET_TEAM_BIND = "300000";
    /**群体列表socket群体绑定用户**/
    public static final String SOCKET_TEAM_BIND_LIST = "400000";
    /**群体socket绑定解除**/
    public static final String SOCKET_TEAM_UNBIND = "500000";
    /**信息中心编码，默认**/
    public static final String SOCKET_DEFAULT = "999999";
    /**信息中心详细编码，默认**/
    public static final String SOCKET_DETAIL_DEFAULT = "999999";

}
