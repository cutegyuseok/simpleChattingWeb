package com.example.wilwebprac.repository;

import com.example.wilwebprac.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class userRepository {

    @Autowired
    userMapper usermapper;

    public int signup(HashMap<String,String> userInfo){return usermapper.signup(userInfo);}

    public HashMap<String,String> login(String email){
        return usermapper.login(email);
    }
}
