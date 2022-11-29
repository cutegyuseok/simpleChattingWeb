package com.example.wilwebprac.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface userMapper {
    public String selectExample();
    public int signup(HashMap<String,String> userInfo);

    public HashMap<String,String> login(String email);

    public int sendChat(HashMap<String,String> chat);
}
