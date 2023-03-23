package com.boot.boardbootproject.controller;

import com.boot.boardbootproject.likes.dto.LikeForm;
import com.boot.boardbootproject.likes.service.LikeCancelService;
import com.boot.boardbootproject.likes.service.LikeRegisterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class LikeController {
    private final LikeRegisterService likeRegisterService;
    private final LikeCancelService likeCancelService;

    @PostMapping("/board/{boardId}/like/{userId}")
    public String likeBoard(@PathVariable Long boardId, @PathVariable Long userId) throws Exception{
        likeRegisterService.register(new LikeForm(boardId, userId));
        return "redirect:/board/"+ boardId;
    }

    @DeleteMapping("/board/{boardId}/like/{userId}")
    public String cancelLikeBoard(@PathVariable Long boardId, @PathVariable Long userId) throws Exception{
        likeCancelService.cancel(new LikeForm(boardId, userId));
        return "redirect:/board/"+ boardId;
    }
}
