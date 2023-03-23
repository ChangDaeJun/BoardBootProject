package com.boot.boardbootproject.controller;


import com.boot.boardbootproject.board.dto.BoardGetForm;
import com.boot.boardbootproject.board.service.BoardGetService;
import com.boot.boardbootproject.comment.service.CommentGetService;
import com.boot.boardbootproject.likes.dto.LikeForm;
import com.boot.boardbootproject.likes.service.LikeGetService;
import com.boot.boardbootproject.Util.Session;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@AllArgsConstructor
public class ViewController {
    private final BoardGetService boardGetService;
    private final LikeGetService likeGetService;
    private final CommentGetService commentGetService;

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
    public String getBoardPage(@PathVariable Long id, Model model, HttpServletRequest request){
        Long userId = Session.getUserId(request);
        model.addAttribute("board", boardGetService.getById(id));
        model.addAttribute("like", likeGetService.isLike(new LikeForm(id, userId)));
        model.addAttribute("comments", commentGetService.getCommentByBoardId(id));
        return "/board/GetBoard";
    }
}
