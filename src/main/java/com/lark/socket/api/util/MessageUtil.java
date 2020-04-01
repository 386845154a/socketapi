package com.lark.socket.api.util;

import com.lark.socket.api.config.Producer;
import com.lark.socket.api.constant.RabbitConstant;
import com.lark.socket.api.vo.MsgSendResultVo;
import com.lark.socket.api.vo.SocketMsgVo;

/**
 * @auther: zhuqz
 * @date: 2020/3/6 16:31
 * @description:  发送消息接口
 */
public class MessageUtil {
    //发送单人消息
    public static MsgSendResultVo sendSingleMsg(SocketMsgVo msgVo){
        MsgSendResultVo resultVo = new MsgSendResultVo();
        if(msgVo!=null){
            try {
                int i = sendMsg(1,msgVo);
                if(i!=1){
                    resultVo.setStatus(false);
                    resultVo.setContent("发送私聊消息出错");
                }
            } catch (Exception e) {
                System.out.println("私聊消息转换二进制错误");
                e.printStackTrace();
            }
        }
        return  resultVo;
    }
    //发送群体消息
    public static MsgSendResultVo sendTeamMsg(SocketMsgVo msgVo){
        MsgSendResultVo resultVo = new MsgSendResultVo();
        if(msgVo!=null){
            try {
               // byte[] msgByte =  CommonUtil.objectToByteArray(msgVo);
                int i = sendMsg(2,msgVo);
                if(i!=1){
                    resultVo.setStatus(false);
                    resultVo.setContent("发送群聊消息出错");
                }
            } catch (Exception e) {
                System.out.println("群聊消息转换二进制错误");
                e.printStackTrace();
            }
        }
        return  resultVo;
    }
    //发送群体绑定消息
    public static MsgSendResultVo sendTeamBindMsg(SocketMsgVo msgVo){
        MsgSendResultVo resultVo = new MsgSendResultVo();
        if(msgVo!=null){
            try {
                // byte[] msgByte =  CommonUtil.objectToByteArray(msgVo);
                int i = sendMsg(3,msgVo);
                if(i!=1){
                    resultVo.setStatus(false);
                    resultVo.setContent("发送群体绑定消息出错");
                }
            } catch (Exception e) {
                System.out.println("群体绑定消息转换二进制错误");
                e.printStackTrace();
            }
        }
        return  resultVo;
    }
    //发送群体列表绑定消息
    public static MsgSendResultVo sendTeamListBindMsg(SocketMsgVo msgVo){
        MsgSendResultVo resultVo = new MsgSendResultVo();
        if(msgVo!=null){
            try {
                // byte[] msgByte =  CommonUtil.objectToByteArray(msgVo);
                int i = sendMsg(4,msgVo);
                if(i!=1){
                    resultVo.setStatus(false);
                    resultVo.setContent("发送群体列表绑定消息出错");
                }
            } catch (Exception e) {
                System.out.println("群体列表绑定消息转换二进制错误");
                e.printStackTrace();
            }
        }
        return  resultVo;
    }
    //发送群体列表绑定消息
    public static MsgSendResultVo sendTeamUnBindMsg(SocketMsgVo msgVo){
        MsgSendResultVo resultVo = new MsgSendResultVo();
        if(msgVo!=null){
            try {
                // byte[] msgByte =  CommonUtil.objectToByteArray(msgVo);
                int i = sendMsg(5,msgVo);
                if(i!=1){
                    resultVo.setStatus(false);
                    resultVo.setContent("发送群体解绑绑定消息出错");
                }
            } catch (Exception e) {
                System.out.println("群体解绑消息转换二进制错误");
                e.printStackTrace();
            }
        }
        return  resultVo;
    }

    //发送消息
    private static int sendMsg(int type,SocketMsgVo msg){
        String key = null;
        String queue = null;
        switch (type){
            case 1://私聊
                {
                    key = RabbitConstant.ROUTINGKEY_SOCKET_PRIVATE_MSG;
                }
                break;

            case 2://群聊
                {
                    key = RabbitConstant.ROUTINGKEY_SOCKET_TEAM_MSG;
                }
                break;

            case 3://群体绑定
            {
                key = RabbitConstant.ROUTINGKEY_SOCKET_TEAM_BIND;
            }
            break;
            case 4://群体列表绑定
            {
                key = RabbitConstant.ROUTINGKEY_SOCKET_TEAMLIST_BIND;
            }
            break;
            case 5://群体通道解绑
            {
                key = RabbitConstant.ROUTINGKEY_SOCKET_TEAM_UNBIND;
            }
            break;
        }

        try {
            int i = Producer.sendMsgToSockerSever(
                    RabbitConstant.EXCHANGE_SOCKET,
                    key,
                    msg
            );
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}