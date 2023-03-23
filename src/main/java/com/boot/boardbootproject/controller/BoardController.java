package com.boot.boardbootproject.controller;

import com.boot.boardbootproject.Util.Session;
import com.boot.boardbootproject.board.dto.BoardGetForm;
import com.boot.boardbootproject.board.dto.BoardWriteForm;
import com.boot.boardbootproject.board.service.BoardDeleteService;
import com.boot.boardbootproject.board.service.BoardGetService;
import com.boot.boardbootproject.board.service.BoardUpdateService;
import com.boot.boardbootproject.board.service.BoardWriteService;
import com.boot.boardbootproject.comment.service.CommentGetService;
import com.boot.boardbootproject.likes.dto.LikeForm;
import com.boot.boardbootproject.likes.service.LikeGetService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {
    private final BoardWriteService boardWriteService;
    private final BoardDeleteService boardDeleteService;
    private final BoardGetService boardGetService;
    private final BoardUpdateService boardUpdateService;
    private final LikeGetService likeGetService;
    private final CommentGetService commentGetService;

    @PostMapping("/board")
    public String writeBoard(BoardWriteForm form, HttpServletRequest request) throws Exception{
        form.setUserId(Session.getUserId(request));
        boardWriteService.write(form);
        return "redirect:/board/list";
    }

    @DeleteMapping("/board/{id}")
    public String deleteBoard(@PathVariable Long id) throws Exception{
        boardDeleteService.deleteById(id);
        return "redirect:/board/list";
    }

    @GetMapping("/board/{id}")
    public String getBoardPage(@PathVariable Long id, Model model, HttpServletRequest request){
        boardUpdateService.addView(id);
        Long userId = Session.getUserId(request);
        model.addAttribute("board", boardGetService.getById(id));
        model.addAttribute("like", likeGetService.isLike(new LikeForm(id, userId)));
        model.addAttribute("comments", commentGetService.getCommentByBoardId(id));
        return "/board/GetBoard";
    }

    @GetMapping("/board/list")
    public String boardListPage(Model model){
        List<BoardGetForm> list = boardGetService.getListAll();
        model.addAttribute("boardList", list);
        return "/board/GetBoardList";
    }
}
