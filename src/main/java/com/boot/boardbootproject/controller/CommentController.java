package com.boot.boardbootproject.controller;

import com.boot.boardbootproject.Util.Session;
import com.boot.boardbootproject.comment.dto.CommentWriteForm;
import com.boot.boardbootproject.comment.service.CommentDeleteService;
import com.boot.boardbootproject.comment.service.CommentWriteService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class CommentController {
    private final CommentWriteService commentWriteService;
    private final CommentDeleteService commentDeleteService;

    @PostMapping("/board/{boardId}/comment")
    public String write(@PathVariable Long boardId, CommentWriteForm form, HttpServletRequest request) throws Exception{
        form.setUserId(Session.getUserId(request));
        form.setBoardId(boardId);
        commentWriteService.write(form);
        return "redirect:/board/"+form.getBoardId();
    }

    @DeleteMapping("/board/{boardId}/comment/{commentId}")
    public String delete(@PathVariable Long boardId, @PathVariable Long commentId) throws Exception{
        commentDeleteService.deleteById(commentId);
        return "redirect:/board/"+ boardId;
    }
}
