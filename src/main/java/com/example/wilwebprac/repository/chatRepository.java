package com.example.wilwebprac.repository;

import com.example.wilwebprac.chatting.DTO.chatDTO;
import com.example.wilwebprac.mapper.chattingMapper;
import com.example.wilwebprac.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class chatRepository {

    @Autowired
    chattingMapper chattingMapper;

    public int sendChat(HashMap<String,String> chat){
        return chattingMapper.sendChat(chat);
    }
    public ArrayList<HashMap<String,String>> bringChat(){
        return chattingMapper.bringChat();
    }
}
