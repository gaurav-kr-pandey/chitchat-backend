package com.chitchat.handlers;

import com.chitchat.dto.MessageRequestKeys;
import com.chitchat.utils.MessageUtils;
import com.chitchat.dto.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;

@Component
public class MessageHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println("-----------"+message.getPayload()+"-----------------");
        Map<String,Object> keys = MessageUtils.parseJsonStringToMap(message.getPayload());
        if(keys.containsKey(MessageRequestKeys.ConnectionRequest.CONNECT.toString())){
            String number =  String.valueOf(keys.get(MessageRequestKeys.ConnectionRequest.CONNECT.toString()));
            WebSocketConnectionFactory.addSession(session,number);
            System.out.println("Connected - session:"+session.getId()+ ", number:"+number);
            return;
        }
        Message msg = MessageUtils.parseMessage(message.getPayload());
        if(MessageUtils.isValidMessage(msg)){
            WebSocketConnectionFactory.addSession(session,msg.getFrom());
            MessageUtils.sendMessage(msg);
        }
        System.out.println(msg);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
