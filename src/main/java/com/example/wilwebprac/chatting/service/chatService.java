package com.example.wilwebprac.chatting.service;

import com.example.wilwebprac.chatting.DTO.chatDTO;
import com.example.wilwebprac.repository.chatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class chatService {

    @Autowired
    chatRepository chatRepository;

    public int sendChat(HashMap<String,String> chat){
      return chatRepository.sendChat(chat);
    }
    public ArrayList<ArrayList<String>> bringChat(){
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
        ArrayList<HashMap<String,String>> hashArr = chatRepository.bringChat();
        for(int i=0;i<hashArr.size();i++){
            ArrayList<String> insideArr = new ArrayList<>();
            insideArr.add(hashArr.get(i).get("nickName"));
            insideArr.add(hashArr.get(i).get("msg"));
            insideArr.add(hashArr.get(i).get("chattime"));
            arr.add(insideArr);
        }
        return arr;
    }
}
