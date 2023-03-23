package com.boot.boardbootproject.controller;


import com.boot.boardbootproject.user.dto.UserGetForm;
import com.boot.boardbootproject.user.dto.UserJoinForm;
import com.boot.boardbootproject.user.dto.UserLoginForm;
import com.boot.boardbootproject.user.service.UserJoinService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
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
}
