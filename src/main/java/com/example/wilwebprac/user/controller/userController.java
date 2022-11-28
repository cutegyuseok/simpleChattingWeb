package com.example.wilwebprac.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class userController {

    @Autowired
    HttpSession session;
    static ArrayList<HashMap<String,String>> userList = new ArrayList<>();

    @PostMapping("signup")
    public String signup(@RequestParam HashMap<String,String> userInfo){
        userList.add(userInfo);
        return "index";
    }

    @PostMapping("login")
    public String login(@RequestParam HashMap<String,String> user){
    for(HashMap<String,String> member : userList){
        if(member.get("email").equals(user.get("email")) && member.get("password").equals(user.get("password"))){
            session.setAttribute("SESSION_NAME",member.get("name"));
            System.out.println(session.getAttribute("SESSION_NAME").toString());
            return "index";
        }
    }
    return "login";
    }

    @GetMapping("goLogout")
    public String logout(){
        if(session.getAttribute("SESSION_NAME")==null)return"index";
        session.setAttribute("SESSION_NAME",null);
        return "index";
    }

}
