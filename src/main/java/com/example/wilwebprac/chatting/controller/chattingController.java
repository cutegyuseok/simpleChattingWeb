package com.example.wilwebprac.chatting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@RestController
public class chattingController {

    static ArrayList<ArrayList<String>> chattingLog = new ArrayList<ArrayList<String>>();

    @GetMapping("/chat/getMsg")
    public ArrayList<ArrayList<String>> getChattingLog(){
        return chattingLog;
    }


    @GetMapping("/chat/sendMsg")
    public void receiveMsg(HttpSession session, String msg){
        ArrayList<String> list=new ArrayList<>();
        if(msg==null||msg.equals(""))
            return;
        String nickName=String.valueOf(session.getAttribute("nickName"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        list.add(nickName);
        list.add(msg);
        list.add(dtf.format(now) );
        chattingLog.add(list);
    }

}
