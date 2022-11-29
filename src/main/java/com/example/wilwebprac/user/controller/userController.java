package com.example.wilwebprac.user.controller;

import com.example.wilwebprac.user.service.userService;
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

    @Autowired
    com.example.wilwebprac.user.service.userService userService;


    @PostMapping("signup")
    public String signup(@RequestParam HashMap<String,String> userInfo){
        if(userService.signup(userInfo)>0) return "index";
        return "signup";
    }

    @PostMapping("login")
    public String login(@RequestParam HashMap<String,String> user){
        String name = userService.login(user.get("email"),user.get("password"));
        if(name!=null){
            session.setAttribute("SESSION_NAME",name);
            return "index";
    }
    return "login";
    }

    @GetMapping("goLogout")
    public String logout(){
        session.setAttribute("SESSION_NAME",null);
        return "index";
    }

}
