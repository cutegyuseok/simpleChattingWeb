package com.example.wilwebprac.chatting.controller;

import com.example.wilwebprac.chatting.DTO.chatDTO;
import com.example.wilwebprac.chatting.service.chatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class chattingController {

    @Autowired
    com.example.wilwebprac.chatting.service.chatService chatService;


    @GetMapping("/chat/getMsg")
    public ArrayList<ArrayList<String>> getChattingLog(){
        return chatService.bringChat();
    }


    @GetMapping("/chat/sendMsg")
    public void receiveMsg(HttpSession session, String msg){
        HashMap<String,String> list = new HashMap<>();
        if(msg==null||msg.equals(""))return;
        String nickName=String.valueOf(session.getAttribute("nickName"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        list.put("nickName",nickName);
        list.put("msg",msg);
        list.put("date", dtf.format(now));
        chatService.sendChat(list);
    }

}
