package com.chitchat.dto;

public class MessageRequestKeys {
    public enum ConnectionRequest {
        CONNECT, DISCONNECT
    }
    public enum MessageType{
        ONE_TO_ONE, ONE_TO_MANY, GROUP
    }
    public enum MessageKey{
        TO, FROM, TEXT, TIMESTAMP
    }
}
