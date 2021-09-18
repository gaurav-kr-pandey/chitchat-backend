package com.chitchat.utils;

import com.chitchat.dto.Message;
import com.chitchat.handlers.WebSocketConnectionFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MessageUtils {
    private static final ObjectMapper mapper;
    private static final TypeReference<HashMap<String,Object>> typeRef;
    static {
        mapper = new ObjectMapper();
        typeRef  = new TypeReference<HashMap<String,Object>>() {};
    }

    public static boolean isValidMessage(Message message){
        return StringUtils.hasText(message.getFrom()) && StringUtils.hasText(message.getText())
                && StringUtils.hasText(message.getTo());
    }

    public static Message parseMessage(String message) throws JsonProcessingException {
        return mapper.readValue(message,Message.class);
    }

    public static Map<String,Object> parseJsonStringToMap(String message) throws JsonProcessingException {
        return mapper.readValue(message,typeRef);
    }

    public static String getMsgJsonObject(Message message) throws JsonProcessingException {
        return mapper.writeValueAsString(message);
    }

    public static void sendMessage(Message message) throws IOException {
        WebSocketSession to = WebSocketConnectionFactory.getSession(message.getTo());
        if(to!=null && to.isOpen()){
            to.sendMessage(new TextMessage(message.getText()));
        }else{
            WebSocketConnectionFactory.removeSession(message.getTo());
        }
    }
}
