package com.chitchat.handlers;

import com.chitchat.dto.Message;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketConnectionFactory {
    private static final Map<String, WebSocketSession> connections;
    static {
        connections = new ConcurrentHashMap<>();
    }

    public static WebSocketSession getSession(String key){
        return connections.get(key);
    }

    public static void addSession(WebSocketSession session, String key){
        connections.put(key,session);
    }

    public static void removeSession(String key){
        connections.remove(key);
    }

    public static Set<String> getOnlineUsers(){
        removeClosedConnections();
        return connections.keySet();
    }

    public static void removeClosedConnections(){
        connections.forEach((key,val)->{
            if(!connections.get(key).isOpen()){
                connections.remove(key);
            }
        });
    }
}
