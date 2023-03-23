package com.boot.boardbootproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewController {

    @GetMapping("/")
    public String homePage(){
        return "index";
    }

    @GetMapping("/user/join")
    public String joinPage(){
        return "/user/JoinUser";
    }


    @GetMapping("/user/login")
    public String loginPage(){
        return "/user/LoginUser";
    }

    @GetMapping("/board/write")
    public String writeBoardPage(){
        return "/board/WriteBoard";
    }
}
