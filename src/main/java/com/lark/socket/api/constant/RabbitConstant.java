package com.lark.socket.api.constant;

/**
 * @auther: zhuqz
 * @date: 2020/3/9 13:34
 * @description:
 */
public class RabbitConstant {

    public static final String EXCHANGE_CONTACT = "exchange_contact";

    public static final String EXCHANGE_SYSMSG = "exchange_sysmsg";
    /**socket消息队列*/
    public static final String EXCHANGE_SOCKET = "exchange_socket";
    /**socket消息队列 begin*/
    /*群体消息（群，会议，系统通知等等）*/
    public static final String ROUTINGKEY_SOCKET_TEAM_MSG = "routingkey_socket_team_msg";
    public static final String QUEUE_SOCKET_TEAM_MSG  = "queue_socket_team_msg";
    /*消息应答*/
    public static final String ROUTINGKEY_SOCKET_MSG_ANSWER = "routingkey_socket_msg_answer";
    public static final String QUEUE_SOCKET_MSG_ANSWER  = "queue_socket_msg_answer";
    /*私人消息*/
    public static final String ROUTINGKEY_SOCKET_PRIVATE_MSG = "routingkey_socket_private_msg";
    public static final String QUEUE_SOCKET_PRIVATE_MSG  = "queue_socket_private_msg";
    /*群体消息绑定（把单个人的id绑定到某个群体，如群、会议等等）*/
    public static final String ROUTINGKEY_SOCKET_TEAM_BIND = "routingkey_socket_team_bind";
    public static final String QUEUE_SOCKET_TEAM_BIND  = "queue_socket_team_bind";
    /*群体消息绑定（把单个人的id绑定到某些群体，如群、会议等等）*/
    public static final String ROUTINGKEY_SOCKET_TEAMLIST_BIND = "routingkey_socket_teamlist_bind";
    public static final String QUEUE_SOCKET_TEAMLIST_BIND  = "queue_socket_teamlist_bind";
    /*群体消息解除绑定（把单个人的id绑定到某个群体，如群、会议等等）*/
    public static final String ROUTINGKEY_SOCKET_TEAM_UNBIND = "routingkey_socket_team_unbind";
    public static final String QUEUE_SOCKET_TEAM_UNBIND  = "queue_socket_team_unbind";
    /**socket消息队列 end*/
    /*来自socket的通知：研讨服务进行人员会议、群组绑定*/
    public static final String QUEUE_CHAT_USER_TEAM_BIND  = "queue_chat_user_team_bind";
}