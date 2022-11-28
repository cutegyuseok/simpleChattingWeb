package com.example.wilwebprac.page.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class pageController {

    @Autowired
    HttpSession session;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("goSignUp")
    public String goSignUp(){
        if(session.getAttribute("SESSION_NAME")!=null)return"index";
        return "signup";
    }

    @GetMapping("goLogin")
    public String goLogin(){
        if(session.getAttribute("SESSION_NAME")!=null)return"index";
        return "login";
    }

    @GetMapping("goUserPage")
    public String goUserPage(HttpSession session){
        if(session.getAttribute("SESSION_NAME")==null)return"index";
        return "userPage";
    }

    @GetMapping("goAsName")
    public String goAsName(){
        if(session.getAttribute("SESSION_NAME")==null)return"index";
        session.setAttribute("nickName",session.getAttribute("SESSION_NAME").toString());
        return "chatting";
    }

    @GetMapping("goAsNickName")
    public String goAsNickName(){
        if(session.getAttribute("SESSION_NAME")==null)return"index";
        return "setNickNamePage";
    }

    @GetMapping("goMain")
    public String setNickName(@RequestParam String nickName){
        if(session.getAttribute("SESSION_NAME")==null)return"index";
        session.setAttribute("nickName",nickName);
        return "chatting";
    }

}
