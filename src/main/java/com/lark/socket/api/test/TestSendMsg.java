package com.lark.socket.api.test;

import com.lark.socket.api.constant.MessageType;
import com.lark.socket.api.util.MessageUtil;
import com.lark.socket.api.vo.SocketMsgDetailVo;
import com.lark.socket.api.vo.SocketMsgVo;
import com.lark.socket.api.vo.SocketTeamBindVo;
import com.lark.socket.api.vo.SocketTeamListBindVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: zhuqz
 * @date: 2020/3/9 14:18
 * @description:
 */
public class TestSendMsg {
    public static void main(String[] args) {
        //单人消息发送
        SocketMsgVo msgVo = new SocketMsgVo();
        msgVo.setCode(MessageType.SOCKET_SINGLE);//外层大类编码
        msgVo.setId("123456");//消息id
        msgVo.setReceiver("qsdeii8d9d");//发送人
        msgVo.setSender("rdil9d9x8d7");//接收人
        SocketMsgDetailVo detailVo = new SocketMsgDetailVo();//消息的详细内容，业务层
        //业务层编码，第三方接入信息中心，需要告知信息中心维护人员，索要业务编码（如果业务编码在信息中心不存在，消息无法发送）
        detailVo.setCode(123456);
        detailVo.setData("this is a test single msg");//发送消息的内容
        msgVo.setMsg(detailVo);
        MessageUtil.sendSingleMsg(msgVo);

        /*//发送群体消息
        SocketMsgVo msgVo2 = new SocketMsgVo();
        msgVo2.setCode(MessageType.SOCKET_TEAM);
        msgVo2.setId("123456");
        msgVo2.setReceiver("qsdeii8d9d");//群体id
        msgVo2.setSender("rdil9d9x8d7");
        SocketMsgDetailVo detailVo2 = new SocketMsgDetailVo();
        detailVo2.setCode(654321);
        detailVo2.setData("this is a team msg");
        msgVo2.setMsg(detailVo2);
        MessageUtil.sendTeamMsg(msgVo2);

        //绑定群体
        SocketMsgVo msgVo3 = new SocketMsgVo();
        msgVo3.setCode(MessageType.SOCKET_TEAM_BIND);
        msgVo3.setId("");
        msgVo3.setReceiver("");
        msgVo3.setSender("");
        SocketMsgDetailVo detailVo3 = new SocketMsgDetailVo();
        detailVo3.setCode(Integer.parseInt(MessageType.SOCKET_DETAIL_DEFAULT));
        SocketTeamBindVo socketTeamBindVo  = new SocketTeamBindVo();
        socketTeamBindVo.setTeamId("teamId");
        List userList = new ArrayList();
        userList.add("tomdsa456445");
        userList.add("toddddsa45dd5");
        socketTeamBindVo.setUserList(userList);
        detailVo3.setData(socketTeamBindVo);
        msgVo3.setMsg(detailVo3);
        MessageUtil.sendTeamBindMsg(msgVo3);

       //群体列表绑定
        SocketMsgVo msgVo4 = new SocketMsgVo();
        msgVo4.setCode(MessageType.SOCKET_TEAM_BIND_LIST);
        msgVo4.setId("");
        msgVo4.setReceiver("");
        msgVo4.setSender("");
        SocketMsgDetailVo detailVo4 = new SocketMsgDetailVo();
        detailVo4.setCode(Integer.parseInt(MessageType.SOCKET_DETAIL_DEFAULT));
        SocketTeamListBindVo socketTeamListBindVo = new SocketTeamListBindVo();
        List<String> groupList = new ArrayList<String>();
        groupList.add("groupid1");
        groupList.add("groupid2");
        socketTeamListBindVo.setTeamList(groupList);
        socketTeamListBindVo.setUserId("tomiddsdfsdsf");
        detailVo4.setData(socketTeamListBindVo);
        msgVo4.setMsg(detailVo4);
        MessageUtil.sendTeamListBindMsg(msgVo4);

        //群体通道解绑
        SocketMsgVo msgVo5 = new SocketMsgVo();
        msgVo5.setCode(MessageType.SOCKET_TEAM_UNBIND);
        msgVo5.setSender("");
        msgVo5.setReceiver("");
        SocketMsgDetailVo detailVo5 = new SocketMsgDetailVo();
        detailVo5.setCode(Integer.parseInt(MessageType.SOCKET_DETAIL_DEFAULT));
        SocketTeamBindVo socketTeamBindVo2  = new SocketTeamBindVo();
        socketTeamBindVo2.setTeamId("teamid");
        List users = new ArrayList();
        users.add("userid1");
        users.add("userid2");
        socketTeamBindVo2.setUserList(users);
        detailVo5.setData(socketTeamBindVo2);
        msgVo5.setMsg(detailVo5);
        MessageUtil.sendTeamUnBindMsg(msgVo5);*/
    }
}