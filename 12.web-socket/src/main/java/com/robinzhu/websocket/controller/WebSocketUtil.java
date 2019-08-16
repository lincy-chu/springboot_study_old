package com.robinzhu.websocket.controller;

import javax.websocket.RemoteEndpoint.Async;
import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketUtil {
    /**
     * 简单实用map进行存储在线的session
     */
    private static final Map<String, Session> ONLINE_SESSION = new ConcurrentHashMap<>();

    // 添加
    public static void addSession(String nickname, Session session) {
        ONLINE_SESSION.put(nickname, session);
    }

    // 移除
    public static void remoteSession(String nickname) {
        ONLINE_SESSION.remove(nickname);
    }

    /**
     * 向某个用户发送消息
     * @param session
     * @param message
     */
    public static void sendMessage(Session session, String message) {
        if (session == null) {
            return;
        }
        // getAsyncRemote()和getBasicRemote()异步与同步
        Async async = session.getAsyncRemote();
        // 发送消息
        async.sendText(message);
    }

    /**
     * 向所有在线用户发送消息
     * @param message
     */
    public static void sendMessageForAll(String message) {
        ONLINE_SESSION.forEach((sessionId, session) -> sendMessage(session, message));
    }
}
