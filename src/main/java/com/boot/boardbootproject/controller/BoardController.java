package com.boot.boardbootproject.controller;

import com.boot.boardbootproject.board.dto.BoardWriteForm;
import com.boot.boardbootproject.board.service.BoardDeleteService;
import com.boot.boardbootproject.board.service.BoardWriteService;
import com.boot.boardbootproject.user.dto.UserGetForm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class BoardController {
    private final BoardWriteService boardWriteService;
    private final BoardDeleteService boardDeleteService;

    @PostMapping("/board")
    public String writeBoard(BoardWriteForm form, HttpServletRequest request) throws Exception{
        Long userId = ((UserGetForm) request.getSession().getAttribute("user")).getId();
        form.setUserId(userId);
        boardWriteService.write(form);
        return "redirect:/board/list";
    }

    @DeleteMapping("/board/{id}")
    public String deleteBoard(@PathVariable Long id) throws Exception{
        System.out.println("dfdddd");
        boardDeleteService.deleteById(id);
        return "redirect:/board/list";
    }
}
