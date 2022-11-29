package com.example.wilwebprac.user.service;

import com.example.wilwebprac.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class userService {

    @Autowired
    com.example.wilwebprac.repository.userRepository userRepository;

    public int signup(HashMap<String,String> userInfo){return userRepository.signup(userInfo);}

    public String login(String email,String password){
        if (userRepository.login(email).get("password").equals(password)) {
            return userRepository.login(email).get("name");
        }else return null;
    }

}
