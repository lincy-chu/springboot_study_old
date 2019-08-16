package com.robinzhu.websocket.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * webSocket简易聊天室
 */
@Component // 需要加上类型@Component注解，使得能被扫描到
// 由于是webSocket，所以原来是@RestController的http形式
// 直接替换成@ServerEndpoint即可，作用是一样的，就是制定一个地址，表示定义一个webSocket的server端
@ServerEndpoint(value = "/my-chat/{nickname}") // 开头需要加上/，否则提示路径无效
@Slf4j
public class WebSocketController {
    /**
     * 连接事件，加入注解
     * @param nickname 昵称
     * @param session 会话
     */
    @OnOpen
    public void onOpen(@PathParam(value = "nickname") String nickname, Session session) {
        String message = "有新游客[" + nickname + "]加入聊天室!";
        log.info(message);
        WebSocketUtil.addSession(nickname, session);
        // 此时可向所有在线用户通知某某登陆了聊天室
        WebSocketUtil.sendMessageForAll(message);
    }

    @OnClose
    public void onClose(@PathParam(value = "nickname") String nickname, Session session) {
        String message = "游客[" + nickname + "]退出聊天室!";
        log.info(message);
        WebSocketUtil.remoteSession(nickname);
        // 此时可向所有在线用户通知某某退出了聊天室
        WebSocketUtil.sendMessageForAll(message);
    }

    @OnMessage
    public void onMessage(@PathParam(value = "nickname") String nickname, String message) {
        // 类似群发
        String info = "游客[" + nickname + "]： " + message;
        log.info(info);
        WebSocketUtil.sendMessageForAll(info);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.error("异常", throwable);
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throwable.printStackTrace();
    }
}
