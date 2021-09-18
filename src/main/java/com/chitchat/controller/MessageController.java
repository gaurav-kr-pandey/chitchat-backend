package com.chitchat.controller;

import com.chitchat.handlers.WebSocketConnectionFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
public class MessageController {

    @GetMapping("/user/online")
    public Set<String> getOnlineUser(){
        return WebSocketConnectionFactory.getOnlineUsers();
    }
}
