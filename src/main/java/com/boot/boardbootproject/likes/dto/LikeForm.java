package com.boot.boardbootproject.likes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeForm {
    private Long boardId;
    private Long userId;

    public LikeForm(Long boardId, Long userId) {
        this.boardId = boardId;
        this.userId = userId;
    }
}
