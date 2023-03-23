package com.boot.boardbootproject.controller;

import com.boot.boardbootproject.board.service.BoardGetService;
import com.boot.boardbootproject.comment.service.CommentGetService;
import com.boot.boardbootproject.likes.service.LikeGetService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class MyPageController {
    private final BoardGetService boardGetService;
    private final LikeGetService likeGetService;
    private final CommentGetService commentGetService;
    @GetMapping("user/{id}")
    public String userPage(@PathVariable Long id, Model model, HttpServletRequest request){
        model.addAttribute("createBoards", boardGetService.getByUserId(id));
        model.addAttribute("likeBoards", likeGetService.getByUserId(id));
        model.addAttribute("createComments", commentGetService.getCommentByUserId(id));
        return "/mypage/MyPage";
    }
}
