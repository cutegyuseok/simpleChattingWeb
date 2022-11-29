package com.example.wilwebprac.mapper;

import org.apache.ibatis.annotations.Mapper;


import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface chattingMapper {
    public int sendChat(HashMap<String,String> chat);

    public ArrayList<HashMap<String,String>> bringChat();
}
