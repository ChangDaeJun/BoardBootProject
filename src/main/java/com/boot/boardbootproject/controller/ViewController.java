package com.boot.boardbootproject.controller;


import com.boot.boardbootproject.board.dto.BoardGetForm;
import com.boot.boardbootproject.board.service.BoardGetService;
import com.boot.boardbootproject.user.dto.UserGetForm;
import com.boot.boardbootproject.user.dto.UserJoinForm;
import com.boot.boardbootproject.user.dto.UserLoginForm;
import com.boot.boardbootproject.user.service.UserJoinService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class ViewController {
    private final BoardGetService boardGetService;

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
    @GetMapping("/board/list")
    public String boardListPage(Model model){
        List<BoardGetForm> list = boardGetService.getListAll();
        model.addAttribute("boardList", list);
        return "/board/GetBoardList";
    }

    @GetMapping("/board/{id}")
    public String getBoardPage(@PathVariable Long id, Model model){
        BoardGetForm board = boardGetService.getById(id);
        model.addAttribute("board", board);
        return "/board/GetBoard";
    }
}
