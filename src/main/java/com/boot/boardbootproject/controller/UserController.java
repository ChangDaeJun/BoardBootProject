package com.boot.boardbootproject.controller;

import com.boot.boardbootproject.user.dto.UserGetForm;
import com.boot.boardbootproject.user.dto.UserJoinForm;
import com.boot.boardbootproject.user.dto.UserLoginForm;
import com.boot.boardbootproject.user.service.UserDeleteService;
import com.boot.boardbootproject.user.service.UserGetService;
import com.boot.boardbootproject.user.service.UserJoinService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserJoinService userJoinService;
    private final UserGetService userGetService;
    private final UserDeleteService userDeleteService;

    @PostMapping("/user/join")
    public String join(UserJoinForm form) throws Exception{
        userJoinService.join(form);
        return "index";
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Long id) throws Exception{
        userDeleteService.delete(id);
        return "index";
    }

    @PostMapping("/user/login")
    public String login(UserLoginForm form, HttpServletRequest request) throws Exception{
        UserGetForm user = userGetService.getByLogin(form);
        request.getSession().setAttribute("user", user);
        return "index";
    }

    @GetMapping("/user/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
    }
}
